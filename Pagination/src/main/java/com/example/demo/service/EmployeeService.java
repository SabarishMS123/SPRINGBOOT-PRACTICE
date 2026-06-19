package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    // Create
    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    // Read All with Pagination
    public Page<Employee> getAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return repo.findAll(pageable);
    }

    // Search by Name
    public Page<Employee> searchByName(String name, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return repo.findByNameContainingIgnoreCase(name, pageable);
    }

    // Search by Role
    public Page<Employee> searchByRole(String role, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return repo.findByRoleContainingIgnoreCase(role, pageable);
    }

    // Update
    public Employee update(Long id, Employee emp) {
        Optional<Employee> existing = repo.findById(id);
        if (existing.isPresent()) {
            Employee e = existing.get();
            e.setName(emp.getName());
            e.setRole(emp.getRole());
            return repo.save(e);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    // Delete
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
