package com.example.jwt.security;
import com.example.jwt.service.RevokedAccessTokenService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.context.annotation.Lazy;
import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final RevokedAccessTokenService revokedService;
    private final UserDetailsService userDetailsService;
    public JwtAuthFilter(JwtService jwtService, RevokedAccessTokenService revokedService, @Lazy UserDetailsService userDetailsService){
        this.jwtService = jwtService; this.revokedService = revokedService; this.userDetailsService = userDetailsService;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest req){
        String p = req.getServletPath();
        // allow register/login/refresh/logout without access token
        return p.equals("/auth/register") || p.equals("/auth/login") || p.equals("/auth/refresh") || p.equals("/auth/logout");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        String h = req.getHeader("Authorization");
        if (h != null && h.startsWith("Bearer ")){
            String token = h.substring(7);
            if (!revokedService.isRevoked(token) && jwtService.validateToken(token, false)){
                String username = jwtService.extractUsername(token, false);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                    var details = userDetailsService.loadUserByUsername(username);
                    var auth = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }
        chain.doFilter(req,res);
    }
}
