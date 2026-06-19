package com.school.sms.repository;

import com.school.sms.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByClassRoomId(Long classRoomId);
    List<Subject> findByTeacherId(Long teacherId);
}