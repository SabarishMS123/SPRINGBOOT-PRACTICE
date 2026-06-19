package com.school.sms.repository;

import com.school.sms.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudentId(Long studentId);
    
    List<Attendance> findByStudentIdAndDateBetween(Long studentId, LocalDate start, LocalDate end);
    
    List<Attendance> findByStudent_ClassRoomIdAndDate(Long classRoomId, LocalDate date);
    
    boolean existsByStudentIdAndDate(Long studentId, LocalDate date);
}