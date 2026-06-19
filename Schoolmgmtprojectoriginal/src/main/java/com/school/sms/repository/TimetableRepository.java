package com.school.sms.repository;
import com.school.sms.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long>{
    boolean existsByClassName(String className);
}
