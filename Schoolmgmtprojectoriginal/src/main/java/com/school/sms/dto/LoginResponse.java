package com.school.sms.dto;

public record LoginResponse(
        String token,
        String role,
        String username,
        Long userId
) {}