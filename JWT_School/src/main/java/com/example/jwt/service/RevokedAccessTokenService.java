package com.example.jwt.service;
import com.example.jwt.entity.RevokedAccessToken;
import com.example.jwt.repository.RevokedAccessTokenRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
@Service
public class RevokedAccessTokenService {
    private final RevokedAccessTokenRepository repo;
    public RevokedAccessTokenService(RevokedAccessTokenRepository repo){ this.repo = repo; }
    public void revoke(String token, Instant exp){
        if (!repo.existsByToken(token)){
            RevokedAccessToken r = new RevokedAccessToken();
            r.setToken(token); r.setExpiresAt(exp); repo.save(r);
        }
    }
    public boolean isRevoked(String token){ return repo.existsByToken(token); }
}
