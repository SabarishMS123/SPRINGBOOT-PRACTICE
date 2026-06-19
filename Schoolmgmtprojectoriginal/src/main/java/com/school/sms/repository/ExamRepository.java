package com.school.sms.repository;

import com.school.sms.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findBySubject_ClassRoomId(Long classRoomId);
    List<Exam> findBySubjectId(Long subjectId);
    List<Exam> findBySubject_Teacher_UserId(Long teacherUserId);
}