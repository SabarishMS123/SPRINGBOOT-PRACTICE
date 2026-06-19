package com.example.crud.controller;
import com.example.crud.entity.Employee;
import com.example.crud.service.EmployeeService;
//import com.example.crud.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saboo_employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    private final EmployeeService  emp;
    public EmployeeController(EmployeeService emp)
    {
    	   this.emp=emp;
    }
    
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee empi){
    	   return ResponseEntity.ok(emp.saveEmployee(empi));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById( @PathVariable Long id)
    {
    	    return ResponseEntity.ok(emp.getEmployeeById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable Long id , @RequestBody Employee empi)
    {
    	     return ResponseEntity.ok(emp.updateEmployee(id,empi));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable Long id)
    {
    	   emp.deleteEmployee(id);
    	   return ResponseEntity.ok("student deleted successfully");
    }
    
    
}
