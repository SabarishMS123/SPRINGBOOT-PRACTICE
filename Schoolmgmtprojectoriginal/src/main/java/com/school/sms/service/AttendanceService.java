package com.school.sms.service;

import com.school.sms.dto.AttendanceDto;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {
    void markAttendance(List<AttendanceDto> attendanceDtos);
    List<AttendanceDto> getAttendanceForCurrentStudent();
    List<AttendanceDto> getAttendanceByStudentId(Long studentId);
    List<AttendanceDto> getAttendanceByClassAndDate(Long classId, LocalDate date);
}
