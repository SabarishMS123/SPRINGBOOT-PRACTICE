package com.example.jwt.repository;

import com.example.jwt.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;



public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
}

