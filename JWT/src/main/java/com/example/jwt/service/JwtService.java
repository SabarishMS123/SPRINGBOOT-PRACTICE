package com.example.jwt.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;

@Service
public class JwtService {
    private final Key accessKey;
    private final Key refreshKey;
    private final long accessTTL;
    private final long refreshTTL;

    public JwtService(
        @Value("${jwt.access.secret}") String accessSecret,
        @Value("${jwt.refresh.secret}") String refreshSecret,
        @Value("${jwt.access.ttl-ms}") long accessTTL,
        @Value("${jwt.refresh.ttl-ms}") long refreshTTL
    ) {
        this.accessKey = Keys.hmacShaKeyFor(accessSecret.getBytes());
        this.refreshKey = Keys.hmacShaKeyFor(refreshSecret.getBytes());
        this.accessTTL = accessTTL;
        this.refreshTTL = refreshTTL;
    }

    public String generateAccessToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + accessTTL))
            .signWith(accessKey, SignatureAlgorithm.HS256)
            .compact();
    }

    public String generateRefreshToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + refreshTTL))
            .signWith(refreshKey, SignatureAlgorithm.HS256)
            .compact();
    }

    public String extractUsername(String token, boolean refresh) {
        return parser(refresh).parseClaimsJws(token).getBody().getSubject();
    }

    public Date extractExpiration(String token, boolean refresh) {
        return parser(refresh).parseClaimsJws(token).getBody().getExpiration();
    }

    public boolean validateToken(String token, boolean refresh) {
        try {
            parser(refresh).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    private JwtParser parser(boolean refresh) {
        return Jwts.parserBuilder().setSigningKey(refresh ? refreshKey : accessKey).build();
    }
}
