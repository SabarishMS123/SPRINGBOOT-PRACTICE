package com.example.jwt.entity;
import jakarta.persistence.*;
import java.time.Instant;
@Entity
@Table(name="revoked_access_tokens", indexes = @Index(name="idx_revoked_token", columnList="token", unique=true))
public class RevokedAccessToken {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  @Column(nullable=false, unique=true, length=512) private String token;
  @Column private Instant expiresAt;
  public RevokedAccessToken(){}
  public Long getId(){return id;}
  public String getToken(){return token;}
  public void setToken(String t){this.token=t;}
  public Instant getExpiresAt(){return expiresAt;}
  public void setExpiresAt(Instant e){this.expiresAt=e;}
}
