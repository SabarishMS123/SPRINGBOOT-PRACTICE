package com.example.service;

import com.example.exception.UserException;
import com.example.modal.User;
import java.util.List;

public interface UserService {

    User getUserFromJwtToken(String token) throws UserException, Exception;

    User getCurrentUser() throws UserException;

    User getUserByEmail(String email) throws UserException, Exception;

    User getUserById(Long id) throws UserException, Exception;

    List<User> getAllUsers();
}