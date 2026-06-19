package com.example.jwt.repository;

import com.example.jwt.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RevokedAccessTokenRepository extends JpaRepository<RevokedAccessToken, Long> {
   boolean existsByToken(String token);
}
