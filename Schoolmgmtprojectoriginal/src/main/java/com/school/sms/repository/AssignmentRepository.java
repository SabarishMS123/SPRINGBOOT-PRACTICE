package com.school.sms.repository;
import com.school.sms.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long>{
    boolean existsByClassName(String className);
}
