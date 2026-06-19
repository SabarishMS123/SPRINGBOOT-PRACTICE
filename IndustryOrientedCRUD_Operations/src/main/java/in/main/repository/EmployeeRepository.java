package in.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.main.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Long>{
  
}
