package com.example.jwt.security;

import com.example.jwt.service.JwtService;
import com.example.jwt.service.RevokedAccessTokenService;
import com.example.jwt.security.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

//@Component
//public class JwtAuthFilter extends OncePerRequestFilter {
//    private final JwtService jwt;
////    private final UserService users;
//    private final UserDetailsService userDetailsService;
//    private final RevokedAccessTokenService revoked;
//
////    public JwtAuthFilter(JwtService jwt, UserService users, RevokedAccessTokenService revoked) {
////        this.jwt = jwt; this.users = users; this.revoked = revoked;
////    }
//    public JwtAuthFilter(JwtService jwtService,@Lazy UserDetailsService userDetailsService, RevokedAccessTokenService revokedRepo) {
//        this.jwt = jwtService;
//        this.userDetailsService = userDetailsService;
//        this.revoked = revokedRepo;
//    }
//
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest req) {
//        return req.getServletPath().startsWith("/auth/");
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
//            throws ServletException, IOException {
//        String h = req.getHeader("Authorization");
//        if (h != null && h.startsWith("Bearer ")) {
//            String token = h.substring(7);
//            if (!revoked.isRevoked(token) && jwt.validateToken(token, false)) {
//                String username = jwt.extractUsername(token, false);
////                var details = users.loadUserByUsername(username);
//                var details = userDetailsService.loadUserByUsername(username);
//                var auth = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
//        }
//        chain.doFilter(req, res);
//    }
//}

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final RevokedAccessTokenService revokedService;
    private final UserDetailsService userDetailsService;

    public JwtAuthFilter(JwtService jwtService,
                         RevokedAccessTokenService revokedService,
                         @Lazy UserDetailsService userDetailsService) { // <- Lazy breaks cycle
        this.jwtService = jwtService;
        this.revokedService = revokedService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest req) {
//        return req.getServletPath().startsWith("/auth/");
    	 String path = req.getServletPath();
    	    return path.startsWith("/auth/login") ||
    	           path.startsWith("/auth/register") ||
    	           path.startsWith("/auth/refresh");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {

        String header = req.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            if (!revokedService.isRevoked(token) && jwtService.validateToken(token, false)) {
                String username = jwtService.extractUsername(token, false);
                var userDetails = userDetailsService.loadUserByUsername(username);
                var auth = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        chain.doFilter(req, res);
    }
}

