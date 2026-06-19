package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000") 
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // 1. Create Employee
    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        return service.save(emp);
    }

    // 2. Get All Employees with Pagination
    @GetMapping
    public Page<Employee> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return service.getAll(page, size, sortBy);
    }

    // 3. Search by Name
    @GetMapping("/search/name")
    public Page<Employee> searchByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return service.searchByName(name, page, size, sortBy);
    }

    // 4. Search by Role
    @GetMapping("/search/role")
    public Page<Employee> searchByRole(
            @RequestParam String role,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return service.searchByRole(role, page, size, sortBy);
    }

    // 5. Update Employee
    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        return service.update(id, emp);
    }

    // 6. Delete Employee
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Employee with id " + id + " deleted successfully.";
    }
}
