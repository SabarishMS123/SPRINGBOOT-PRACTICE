package com.example.empmgmt.repository;

import com.example.empmgmt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public interface Employeerepository extends JpaRepository<Employee, Long> {
}
