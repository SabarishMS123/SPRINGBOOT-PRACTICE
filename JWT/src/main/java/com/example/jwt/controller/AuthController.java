package com.example.jwt.controller;

import com.example.jwt.entity.UserEntity;
import com.example.jwt.service.JwtService;
import com.example.jwt.security.UserService;
import com.example.jwt.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService users;
    private final JwtService jwt;
    private final AuthenticationManager authManager;
    private final RefreshTokenService refreshTokens;
    private final RevokedAccessTokenService revoked;

    public AuthController(UserService u, JwtService j, AuthenticationManager am,
                          RefreshTokenService rts, RevokedAccessTokenService r) {
        this.users=u; this.jwt=j; this.authManager=am; this.refreshTokens=rts; this.revoked=r;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String,String> req) {
        UserEntity u = new UserEntity();
        u.setUsername(req.get("username"));
        u.setPassword(req.get("password"));
        u.setRole(req.get("role"));
        users.save(u);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> req) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.get("username"), req.get("password")));
        String access = jwt.generateAccessToken(req.get("username"));
        String refresh = jwt.generateRefreshToken(req.get("username"));

        
        refreshTokens.create(
                users.findByUsername(req.get("username")),
                refresh,
                jwt.extractExpiration(refresh, true).toInstant()
        );

        return ResponseEntity.ok(Map.of("access", access, "refresh", refresh));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String,String> req) {
        String token = req.get("refresh");
        var rt = refreshTokens.findValid(token);
        if (rt==null) return ResponseEntity.status(401).body("Invalid refresh token");
        String username = rt.getUser().getUsername();
        String access = jwt.generateAccessToken(username);
        return ResponseEntity.ok(Map.of("access", access));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody Map<String,String> req) {
        String access = req.get("access");
        String refresh = req.get("refresh");
        if (access!=null) revoked.revoke(access, jwt.extractExpiration(access,false).toInstant());
        if (refresh!=null) refreshTokens.revoke(refresh);
        return ResponseEntity.ok("Logged out");
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication auth) {
        return ResponseEntity.ok(Map.of("username", auth.getName()));
    }
}
