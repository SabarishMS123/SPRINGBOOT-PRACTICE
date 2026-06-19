package com.school.sms.service.impl;

import com.school.sms.dto.AttendanceDto;
import com.school.sms.entity.Attendance;
import com.school.sms.entity.Student;
import com.school.sms.entity.User;
import com.school.sms.exception.ResourceNotFoundException;
import com.school.sms.repository.AttendanceRepository;
import com.school.sms.repository.StudentRepository;
import com.school.sms.service.AttendanceService;
import com.school.sms.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final UserService userService;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository,
                                 StudentRepository studentRepository,
                                 UserService userService) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
        this.userService = userService;
    }

    @Override
    public void markAttendance(List<AttendanceDto> dtos) {
        List<Attendance> attendances = dtos.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());

        attendanceRepository.saveAll(attendances);
    }

    @Override
    public List<AttendanceDto> getAttendanceForCurrentStudent() {
        User currentUser = userService.getCurrentUser();

        Student student = studentRepository.findByUserId(currentUser.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student profile not found"));

        return attendanceRepository.findByStudentId(student.getId())
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AttendanceDto> getAttendanceByStudentId(Long studentId) {
        return attendanceRepository.findByStudentId(studentId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AttendanceDto> getAttendanceByClassAndDate(Long classId, LocalDate date) {
        return attendanceRepository
                .findByStudent_ClassRoomIdAndDate(classId, date)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    /* =====================
       Mapping methods
       ===================== */

    private Attendance mapToEntity(AttendanceDto dto) {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id " + dto.getStudentId()));

        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(dto.getDate() != null ? dto.getDate() : LocalDate.now());
        attendance.setPresent(dto.isPresent());
        attendance.setRemarks(dto.getRemarks());

        return attendance;
    }

    private AttendanceDto mapToDto(Attendance attendance) {
        AttendanceDto dto = new AttendanceDto();
        dto.setStudentId(((Object) attendance.getStudent()).getId());
        dto.setStudentName(((Object) attendance.getStudent()).getFullName());
        dto.setDate(attendance.getDate());
        dto.setPresent(attendance.isPresent());
        dto.setRemarks(attendance.getRemarks());
        return dto;
    }
}
