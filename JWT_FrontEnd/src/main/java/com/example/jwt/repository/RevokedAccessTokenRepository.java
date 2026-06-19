package com.example.jwt.repository;
import com.example.jwt.entity.RevokedAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RevokedAccessTokenRepository extends JpaRepository<RevokedAccessToken, Long> {
    boolean existsByToken(String token);
}
