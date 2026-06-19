package com.example.jwt.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class RevokedAccessToken {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, length=512)
    private String token;

    private Instant expiresAt;

    public Long getId() { return id; }
    public String getToken() { return token; }
    public void setToken(String t) { this.token = t; }
    public Instant getExpiresAt() { return expiresAt; }
    public void setExpiresAt(Instant e) { this.expiresAt = e; }
}
