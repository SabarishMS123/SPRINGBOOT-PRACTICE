package com.school.sms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnnouncementDto {
    private Long id;
    private String title;
    private String content;
    private String postedBy; // Admin or Teacher name
    private LocalDateTime postedDate;
    private String targetAudience; // e.g., "ALL", "CLASS_10A", "PARENTS"
}