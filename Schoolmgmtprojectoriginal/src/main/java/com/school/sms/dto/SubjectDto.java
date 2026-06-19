package com.school.sms.dto;

import lombok.Data;

@Data
public class SubjectDto {
    private Long id;
    private String subjectName;
    private String code; // e.g., MATH101
    private Long classId;
    private Long teacherId;
    private String teacherName;
}