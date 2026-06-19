package com.school.sms.dto;

import lombok.Data;

@Data
public class TeacherDto {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String subjectSpecialization;
    private Long userId; // Reference to User entity
}