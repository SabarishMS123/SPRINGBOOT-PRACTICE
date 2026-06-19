package com.school.sms.service.impl;

import com.school.sms.dto.StudentDto;
import com.school.sms.entity.*;
import com.school.sms.exception.ResourceNotFoundException;
import com.school.sms.repository.ClassRoomRepository;
import com.school.sms.repository.StudentRepository;
import com.school.sms.service.StudentService;
import com.school.sms.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ClassRoomRepository classRoomRepository;
    private final UserService userService;

    public StudentServiceImpl(StudentRepository studentRepository,
                              ClassRoomRepository classRoomRepository,
                              UserService userService) {
        this.studentRepository = studentRepository;
        this.classRoomRepository = classRoomRepository;
        this.userService = userService;
    }

    @Override
    public StudentDto createStudent(StudentDto dto) {

        if (studentRepository.existsByRollNumber(dto.getRollNumber())) {
            throw new IllegalStateException("Student with this roll number already exists");
        }

        Student student = new Student();
        student.setFullName(dto.getFullName());
        student.setRollNumber(dto.getRollNumber());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());

        ClassRoom classRoom = classRoomRepository.findById(dto.getClassRoomId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Class not found"));
        student.setClassRoom(classRoom);

        if (dto.getUserId() != null) {
            User user = userService.getUserById(dto.getUserId());
            student.setUser(user);
        }

        if (dto.getParentId() != null) {
            User parent = userService.getUserById(dto.getParentId());
            student.setParent(parent);
        }

        return mapToDto(studentRepository.save(student));
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentsByClass(Long classId) {
        return studentRepository.findByClassRoomId(classId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentsByTeacher() {
        User teacher = userService.getCurrentUser();
        return studentRepository
                .findByClassRoom_ClassTeacher_UserId(teacher.getId())
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getChildrenOfCurrentParent() {
        User parent = userService.getCurrentUser();
        return studentRepository.findByParentId(parent.getId())
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    /* =====================
       Mapping
       ===================== */

    private StudentDto mapToDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setFullName(student.getFullName());
        dto.setRollNumber(student.getRollNumber());
        dto.setEmail(student.getEmail());
        dto.setPhone(student.getPhone());

        if (student.getClassRoom() != null) {
            dto.setClassRoomId(student.getClassRoom().getId());
            dto.setClassName(student.getClassRoom().getClassName());
        }
        if (student.getUser() != null) {
            dto.setUserId(student.getUser().getId());
        }
        if (student.getParent() != null) {
            dto.setParentId(student.getParent().getId());
        }
        return dto;
    }
}
