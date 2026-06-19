package com.school.sms.service;

import com.school.sms.dto.RegisterRequest;
import com.school.sms.entity.User;

public interface UserService {
    User registerUser(RegisterRequest registerRequest);
    User getCurrentUser();
    User findByUsername(String username);
    User getUserById(Long id);
}
