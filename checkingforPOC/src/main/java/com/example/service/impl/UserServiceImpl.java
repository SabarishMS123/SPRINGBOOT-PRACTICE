package com.example.service.impl;

import com.example.configuration.JwtProvider;
import com.example.exception.UserException;
import com.example.modal.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    public UserServiceImpl(UserRepository userRepository, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }


    @Override
    public User getUserFromJwtToken(String token) throws UserException, Exception {
        String email=jwtProvider.getEmailFromToken(token);
        User user = userRepository.findByEmail(email);
        if(user == null)
        {
            throw new Exception("Invalid token");
        }
        return user;
    }

    @Override
    public User getCurrentUser() throws UserException {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email);
        if(user == null)
        {
            throw new UserException("user not found");
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) throws UserException {
        User user = userRepository.findByEmail(email);
        if(user == null)
        {
            throw new UserException("user not found");
        }
        return user;
    }

    @Override
    public User getUserById(Long id) throws UserException, Exception {

        return  userRepository.findById(id).orElseThrow(
                ()->new Exception("user not found ")
        );
    }

    @Override

    public List<User> getAllUsers() {

        return  userRepository.findAll();
    }
}
