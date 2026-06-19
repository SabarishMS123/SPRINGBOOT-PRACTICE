package com.school.sms.service.impl;

import com.school.sms.dto.ExamDto;
import com.school.sms.dto.ResultDto;
import com.school.sms.entity.*;
import com.school.sms.exception.ResourceNotFoundException;
import com.school.sms.repository.*;
import com.school.sms.service.ExamService;
import com.school.sms.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final ResultRepository resultRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final UserService userService;

    public ExamServiceImpl(ExamRepository examRepository,
                           ResultRepository resultRepository,
                           SubjectRepository subjectRepository,
                           StudentRepository studentRepository,
                           UserService userService) {
        this.examRepository = examRepository;
        this.resultRepository = resultRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
        this.userService = userService;
    }

    @Override
    public ExamDto createExam(ExamDto dto) {

        Subject subject = subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Subject not found"));

        Exam exam = new Exam();
        exam.setExamName(dto.getExamName());
        exam.setExamDate(dto.getExamDate());
        exam.setTotalMarks(dto.getTotalMarks());
        exam.setSubject(subject);

        return mapExamToDto(examRepository.save(exam));
    }

    @Override
    public void uploadResult(ResultDto dto) {

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found"));

        Exam exam = examRepository.findById(dto.getExamId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Exam not found"));

        // Prevent duplicate results
        if (resultRepository.existsByStudentIdAndExamId(student.getId(), exam.getId())) {
            throw new IllegalStateException("Result already exists for this student and exam");
        }

        Result result = new Result();
        result.setStudent(student);
        result.setExam(exam);
        result.setMarksObtained(dto.getMarksObtained());
        result.setGrade(dto.getGrade());
        result.setRemarks(dto.getRemarks());

        resultRepository.save(result);
    }

    @Override
    public List<ExamDto> getAllExams() {
        return examRepository.findAll()
                .stream()
                .map(this::mapExamToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExamDto> getExamsForCurrentStudent() {

        User user = userService.getCurrentUser();

        Student student = studentRepository.findByUserId(user.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student profile not found"));

        return examRepository.findBySubject_ClassRoomId(
                        student.getClassRoom().getId())
                .stream()
                .map(this::mapExamToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExamDto> getExamsByClass(Long classId) {
        return examRepository.findBySubject_ClassRoomId(classId)
                .stream()
                .map(this::mapExamToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResultDto> getResultsForCurrentStudent() {

        User user = userService.getCurrentUser();

        Student student = studentRepository.findByUserId(user.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student profile not found"));

        return resultRepository.findByStudentId(student.getId())
                .stream()
                .map(this::mapResultToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResultDto> getResultsByStudentId(Long studentId) {
        return resultRepository.findByStudentId(studentId)
                .stream()
                .map(this::mapResultToDto)
                .collect(Collectors.toList());
    }

    /* =====================
       Mapping Methods
       ===================== */

    private ExamDto mapExamToDto(Exam exam) {
        ExamDto dto = new ExamDto();
        dto.setId(exam.getId());
        dto.setExamName(exam.getExamName());
        dto.setExamDate(exam.getExamDate());
        dto.setTotalMarks(exam.getTotalMarks());

        if (exam.getSubject() != null) {
            dto.setSubjectId(exam.getSubject().get
