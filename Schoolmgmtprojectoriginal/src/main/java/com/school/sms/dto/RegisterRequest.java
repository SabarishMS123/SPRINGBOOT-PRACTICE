package com.school.sms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(

        @NotBlank(message = "Full name is required")
        String fullName,

        @NotBlank(message = "Username is required")
        @Size(min = 4, max = 20)
        String username,

        @NotBlank(message = "Email is required")
        @Email
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 6)
        String password,

        @NotBlank(message = "Role is required")
        String role  // "ADMIN", "TEACHER", "STUDENT", "PARENT"
) {}