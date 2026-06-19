package com.school.sms.service.impl;

import com.school.sms.dto.TeacherDto;
import com.school.sms.entity.Teacher;
import com.school.sms.entity.User;
import com.school.sms.exception.ResourceNotFoundException;
import com.school.sms.repository.TeacherRepository;
import com.school.sms.service.TeacherService;
import com.school.sms.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final UserService userService;

    public TeacherServiceImpl(TeacherRepository teacherRepository,
                              UserService userService) {
        this.teacherRepository = teacherRepository;
        this.userService = userService;
    }

    @Override
    public TeacherDto createTeacher(TeacherDto dto) {

        if (dto.getUserId() != null &&
            teacherRepository.existsByUserId(dto.getUserId())) {
            throw new IllegalStateException("Teacher already exists for this user");
        }

        Teacher teacher = new Teacher();
        teacher.setFullName(dto.getFullName());
        teacher.setEmail(dto.getEmail());
        teacher.setPhone(dto.getPhone());
        teacher.setSubjectSpecialization(dto.getSubjectSpecialization());

        if (dto.getUserId() != null) {
            User user = userService.getUserById(dto.getUserId());
            teacher.setUser(user);
        }

        return mapToDto(teacherRepository.save(teacher));
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto getTeacherByUserId(Long userId) {
        Teacher teacher = teacherRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Teacher not found for user"));

        return mapToDto(teacher);
    }

    /* =====================
       Mapping
       ===================== */

    private TeacherDto mapToDto(Teacher teacher) {
        TeacherDto dto = new TeacherDto();
        dto.setId(teacher.getId());
        dto.setFullName(teacher.getFullName());
        dto.setEmail(teacher.getEmail());
        dto.setPhone(teacher.getPhone());
        dto.setSubjectSpecialization(teacher.getSubjectSpecialization());
        if (teacher.getUser() != null) {
            dto.setUserId(teacher.getUser().getId());
        }
        return dto;
    }
}
