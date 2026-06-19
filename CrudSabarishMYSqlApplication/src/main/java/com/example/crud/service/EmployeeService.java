package com.example.crud.service;
import com.example.crud.entity.Employee;
import com.example.crud.repository.EmployeeRepository;
//import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
     private final EmployeeRepository empr;
     public EmployeeService(EmployeeRepository empr)
     {
    	    this.empr=empr;
     }
     
     public Employee saveEmployee(Employee emp)
     {
    	   return empr.save(emp);
     }
     
     public List<Employee> getAllEmployee()
     {
    	   return empr.findAll();
     }
     
     public Employee getEmployeeById(Long id)
     {
    	   return empr.findById(id).orElse(null);
     }
     public Employee updateEmployee(Long id,Employee empdet)
     {
    	     Employee empd=empr.findById(id).orElseThrow();
    	     empd.setName(empdet.getName());
    	     empd.setEmail(empdet.getEmail());
    	     empd.setDepartment(empdet.getDepartment());
    	     return  empr.save(empd);
     }
     
     public void deleteEmployee(Long id)
     {
    	   empr.deleteById(id);
     }
     
}
