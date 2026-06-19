package com.school.sms.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceDto {
    private Long studentId;
    private String studentName;
    private LocalDate date;
    private boolean present; // true = present, false = absent
    private String remarks;
	public Long getStudentId() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object isPresent() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getRemarks() {
		// TODO Auto-generated method stub
		return null;
	}
}