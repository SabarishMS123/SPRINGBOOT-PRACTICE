package com.example.jwt.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class RefreshToken {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true, length=512)
    private String token;

    @ManyToOne(optional=false)
    private UserEntity user;

    private Instant expiresAt;
    private boolean revoked;

    public Long getId() { return id; }
    public String getToken() { return token; }
    public void setToken(String t) { this.token = t; }
    public UserEntity getUser() { return user; }
    public void setUser(UserEntity u) { this.user = u; }
    public Instant getExpiresAt() { return expiresAt; }
    public void setExpiresAt(Instant e) { this.expiresAt = e; }
    public boolean isRevoked() { return revoked; }
    public void setRevoked(boolean r) { this.revoked = r; }
}
