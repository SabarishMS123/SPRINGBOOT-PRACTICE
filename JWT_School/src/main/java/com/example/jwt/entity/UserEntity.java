package com.example.jwt.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false) private String username;
    @Column(nullable=false) private String password;
    @Column(nullable=false) private String role; // ROLE_USER, ROLE_MANAGER, ROLE_ADMIN

    public UserEntity() {}
    public Long getId(){return id;}
    public String getUsername(){return username;}
    public void setUsername(String u){this.username=u;}
    public String getPassword(){return password;}
    public void setPassword(String p){this.password=p;}
    public String getRole(){return role;}
    public void setRole(String r){this.role=r;}
}
