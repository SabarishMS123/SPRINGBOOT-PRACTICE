package com.school.sms.repository;

import com.school.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClassRoomId(Long classRoomId);
    
    @Query("SELECT s FROM Student s WHERE s.parent.id = :parentId")
    List<Student> findByParentId(Long parentId);
    
    List<Student> findByClassRoom_ClassTeacher_UserId(Long teacherUserId);
    
    boolean existsByRollNumber(String rollNumber);
}