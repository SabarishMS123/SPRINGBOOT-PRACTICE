package com.school.sms.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String fullName;
    private String rollNumber;
    private String email;
    private String phone;
    private Long classRoomId;
    private String className;
    private Long parentId; // Optional: link to parent user
    private Long userId;
}