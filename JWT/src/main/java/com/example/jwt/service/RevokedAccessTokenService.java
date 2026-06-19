package com.example.jwt.service;

import com.example.jwt.entity.RevokedAccessToken;
import com.example.jwt.repository.RevokedAccessTokenRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class RevokedAccessTokenService {
    private final RevokedAccessTokenRepository repo;

    public RevokedAccessTokenService(RevokedAccessTokenRepository repo) { 
        this.repo = repo; 
    }

    public void revoke(String token, Instant exp) {
        System.out.println("Revoking token: " + token);
        if (!repo.existsByToken(token)) {
            RevokedAccessToken r = new RevokedAccessToken();
            r.setToken(token);
            r.setExpiresAt(exp);
            repo.save(r);
            System.out.println("Token saved to revoked list.");
        } else {
            System.out.println("Token already revoked.");
        }
    }

    public boolean isRevoked(String token) {
        boolean revoked = repo.existsByToken(token);
        System.out.println("Checking revoked status for token: " + token + " => " + revoked);
        return revoked;
    }
}

