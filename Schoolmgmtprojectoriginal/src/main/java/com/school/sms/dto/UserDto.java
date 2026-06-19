package com.school.sms.dto;

public record UserDto(
        Long id,
        String fullName,
        String username,
        String email,
        String role
) {}