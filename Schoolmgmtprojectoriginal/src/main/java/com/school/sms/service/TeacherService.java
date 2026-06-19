package com.school.sms.service;

import com.school.sms.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto createTeacher(TeacherDto teacherDto);
    List<TeacherDto> getAllTeachers();
    TeacherDto getTeacherByUserId(Long userId);
}