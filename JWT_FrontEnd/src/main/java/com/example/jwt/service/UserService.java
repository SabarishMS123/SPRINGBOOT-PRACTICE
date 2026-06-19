package com.example.jwt.service;
import com.example.jwt.entity.UserEntity;
import com.example.jwt.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;
    public UserService(UserRepository repo, PasswordEncoder encoder){
        this.repo = repo; this.encoder = encoder;
    }
    public UserEntity save(UserEntity u){
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }
    public Optional<UserEntity> findByUsername(String username){ return repo.findByUsername(username); }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity u = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return User.withUsername(u.getUsername()).password(u.getPassword()).roles(u.getRole().replace("ROLE_","")).build();
    }
}
