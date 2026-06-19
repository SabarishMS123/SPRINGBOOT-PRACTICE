package com.school.sms.dto;

import lombok.Data;

@Data
public class ClassDto {
    private Long id;
    private String className; // e.g., "10A", "12B"
    private String section;
    private Long teacherId; // Class teacher
    private String teacherName;
}