package com.school.sms.dto;

import lombok.Data;

@Data
public class ResultDto {
    private Long id;
    private Long studentId;
    private String studentName;
    private Long examId;
    private String examName;
    private Integer marksObtained;
    private Integer totalMarks;
    private String grade;
    private String remarks;
}