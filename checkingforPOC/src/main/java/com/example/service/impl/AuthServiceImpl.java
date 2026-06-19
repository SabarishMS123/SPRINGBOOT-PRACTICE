package com.example.service.impl;
import com.example.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.repository.UserRepository;
import com.example.configuration.JwtProvider;
import com.example.domain.UserRole;
import com.example.exception.UserException;
import com.example.modal.User;
import com.example.payload.dto.UserDto;
import com.example.payload.response.AuthResponse;
import com.example.service.AuthService;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final CustomUserImplementation customUserDetailsService; // if needed

    @Override
    public AuthResponse signup(UserDto userDto) throws UserException {
        User existingUser = userRepository.findByEmail(userDto.getEmail());
        if (existingUser != null) {
            throw new UserException("Email id already registered!");
        }

        if (userDto.getRole().equals(UserRole.ROLE_ADMIN)) {
            throw new UserException("Role admin is not allowed!");
        }

        User newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword())); // CRITICAL
        newUser.setRole(userDto.getRole());
        newUser.setFullName(userDto.getFullName());
        newUser.setPhone(userDto.getPhone());
        newUser.setLastLogin(LocalDateTime.now());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(newUser); // Save the correct user

        // Optional: authenticate user after signup
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDto.getEmail(), userDto.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Successfully registered!");
        authResponse.setUser(UserMapper.toDto(savedUser));

        return authResponse;
    }

    @Override
    public AuthResponse login(UserDto userDto) throws UserException {
        String email =userDto.getEmail();
        String password = userDto.getPassword();
        Authentication authentication = authenticate(email,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Collection<?extends GrantedAuthority> authorities =authentication.getAuthorities();
        String role = authorities.iterator().next().getAuthority();
        User user = userRepository.findByEmail(email);
        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);
        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();


        authResponse.setJwt(jwt);
        authResponse.setMessage("Successfully Logined!");
        authResponse.setUser(UserMapper.toDto(user));
        return authResponse;
    }
    private Authentication authenticate (String email , String password) throws UserException {
       UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
       if(userDetails == null )
       {
           throw new UserException("email id doesn't exist "+email);
       }
       if(!passwordEncoder.matches(password,userDetails.getPassword())){
           throw new UserException("password doesn't match");
       }
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }
}

