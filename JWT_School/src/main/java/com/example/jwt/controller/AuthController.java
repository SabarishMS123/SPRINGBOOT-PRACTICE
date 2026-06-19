package com.example.jwt.controller;
import com.example.jwt.entity.RefreshToken;
import com.example.jwt.entity.UserEntity;
import com.example.jwt.security.JwtService;
import com.example.jwt.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final RefreshTokenService refreshTokenService;
    private final RevokedAccessTokenService revokedService;

    public AuthController(UserService us, JwtService js, AuthenticationManager am, RefreshTokenService rts, RevokedAccessTokenService ras){
        this.userService = us; this.jwtService = js; this.authManager = am; this.refreshTokenService = rts; this.revokedService = ras;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String,String> b){
        String u=b.get("username"), p=b.get("password"), role=b.getOrDefault("role","ROLE_USER");
        if (u==null || p==null) return ResponseEntity.badRequest().body("username and password required");
        if (userService.findByUsername(u).isPresent()) return ResponseEntity.badRequest().body("User exists");
        UserEntity user = new UserEntity(); user.setUsername(u); user.setPassword(p); user.setRole(role);
        userService.save(user);
        return ResponseEntity.ok(Map.of("username", u, "role", role));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> b){
        String u=b.get("username"), p=b.get("password");
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(u,p));
        UserEntity user = userService.findByUsername(u).orElseThrow();
        String access = jwtService.generateAccessToken(u, Map.of("role", user.getRole()));
        String refresh = jwtService.generateRefreshToken(u);
        Instant exp = jwtService.extractExpiration(refresh, true).toInstant();
        refreshTokenService.create(user, refresh, exp);
        return ResponseEntity.ok(Map.of("accessToken", access, "refreshToken", refresh, "role", user.getRole()));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String,String> b){
        String token = b.get("refreshToken");
        if (token==null) return ResponseEntity.badRequest().body("refreshToken required");
        RefreshToken rt = refreshTokenService.findValid(token);
        if (rt==null) return ResponseEntity.status(401).body("Invalid or revoked refresh token");
        // rotate: revoke old
        refreshTokenService.revoke(token);
        String username = rt.getUser().getUsername();
        String newAccess = jwtService.generateAccessToken(username, Map.of("role", rt.getUser().getRole()));
        String newRefresh = jwtService.generateRefreshToken(username);
        Instant newExp = jwtService.extractExpiration(newRefresh, true).toInstant();
        refreshTokenService.create(rt.getUser(), newRefresh, newExp);
        return ResponseEntity.ok(Map.of("accessToken", newAccess, "refreshToken", newRefresh));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody Map<String,String> b, @RequestHeader(value="Authorization", required=false) String authHeader){
        String refresh = b.get("refreshToken"); String access = (authHeader!=null && authHeader.startsWith("Bearer "))?authHeader.substring(7):b.get("accessToken");
        if (refresh!=null) refreshTokenService.revoke(refresh);
        if (access!=null) {
            revokedService.revoke(access, jwtService.extractExpiration(access,false).toInstant());
        }
        return ResponseEntity.ok("Logged out");
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication auth){
        if (auth==null) return ResponseEntity.status(401).body("Not authenticated");
        return ResponseEntity.ok(Map.of("username", auth.getName(), "authorities", auth.getAuthorities()));
    }
}
