package com.school.sms.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExamDto {
    private Long id;
    private String examName; // e.g., "Mid Term", "Final Exam"
    private LocalDate examDate;
    private Long subjectId;
    private String subjectName;
    private Long classId;
    private String className;
    private Integer totalMarks;
}