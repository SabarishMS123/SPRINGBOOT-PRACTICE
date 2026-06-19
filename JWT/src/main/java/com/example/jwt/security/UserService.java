package com.example.jwt.security;

import com.example.jwt.entity.UserEntity;
import com.example.jwt.repository.UserRepository;

//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//@Service
//public class UserService implements UserDetailsService {
//    private final UserRepository repo;
//    private final PasswordEncoder encoder;
//
//    public UserService(UserRepository repo, PasswordEncoder encoder) {
//        this.repo = repo; this.encoder = encoder;
//    }
//
//    public UserEntity save(UserEntity u) {
//        u.setPassword(encoder.encode(u.getPassword()));
//        return repo.save(u);
//    }
//
//    public UserEntity findByUsername(String username) {
//        return repo.findByUsername(username).orElse(null);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity u = repo.findByUsername(username).orElseThrow();
//        return User.withUsername(u.getUsername())
//                .password(u.getPassword())
//                .roles("USER")
//                .build();
//    }
//}

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    // Save user
    public UserEntity save(UserEntity u) {
        u.setPassword(passwordEncoder.encode(u.getPassword())); // use passwordEncoder
        return userRepository.save(u); // use userRepository
    }

    // Find user
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    // Required by Spring Security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity u = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return User.withUsername(u.getUsername())
                .password(u.getPassword())
                .roles("USER") // or u.getRole() if you have roles
                .build();
    }
}


