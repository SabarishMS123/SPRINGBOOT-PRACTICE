package com.school.sms.repository;

import com.school.sms.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByStudentId(Long studentId);
    List<Result> findByExamId(Long examId);
    List<Result> findByStudent_ClassRoomId(Long classRoomId);
    List<Result> findByExam_Subject_ClassRoomId(Long classRoomId);
}