package com.example.jwt.service;

import com.example.jwt.entity.RefreshToken;
import com.example.jwt.entity.UserEntity;
import com.example.jwt.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {
    private final RefreshTokenRepository repo;

    public RefreshTokenService(RefreshTokenRepository repo) { this.repo = repo; }

    public RefreshToken create(UserEntity user, String token, Instant exp) {
        RefreshToken rt = new RefreshToken();
        rt.setUser(user);
        rt.setToken(token);  
        rt.setExpiresAt(exp);
        rt.setRevoked(false);
        return repo.save(rt);
    }
    public RefreshToken findValid(String token) {
        return repo.findByToken(token)
                .filter(rt -> !rt.isRevoked() && rt.getExpiresAt().isAfter(Instant.now()))
                .orElse(null);
    }

    public void revoke(String token) {
        repo.findByToken(token).ifPresent(rt -> { rt.setRevoked(true); repo.save(rt); });
    }
}
