package com.school.sms.service;

import com.school.sms.dto.ExamDto;
import com.school.sms.dto.ResultDto;

import java.util.List;

public interface ExamService {

    ExamDto createExam(ExamDto examDto);

    void uploadResult(ResultDto resultDto);

    List<ExamDto> getAllExams();

    List<ExamDto> getExamsForCurrentStudent();

    List<ExamDto> getExamsByClass(Long classId);

    List<ResultDto> getResultsForCurrentStudent();

    List<ResultDto> getResultsByStudentId(Long studentId);
}
