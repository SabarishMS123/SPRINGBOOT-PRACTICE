package com.school.sms.service;

import com.school.sms.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    List<StudentDto> getStudentsByClass(Long classId);
    List<StudentDto> getStudentsByTeacher(); // Based on current teacher
    List<StudentDto> getChildrenOfCurrentParent(); // For logged-in parent
}