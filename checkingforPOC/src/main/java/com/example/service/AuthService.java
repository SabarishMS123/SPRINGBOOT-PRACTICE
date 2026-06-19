package com.example.service;

import com.example.exception.UserException;
import com.example.payload.dto.UserDto;
import com.example.payload.response.AuthResponse;

public interface AuthService {
    AuthResponse signup(UserDto userDto) throws UserException;
    AuthResponse login(UserDto userDto) throws UserException;
}
