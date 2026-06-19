package in.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import in.main.entity.Employee;
import in.main.service.EmployeeService;

// User kudukkara request aah get pandrathhukku Controller class use pandrom.



@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	
	//CREATE
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return es.saveEmployee(employee);
	}

	 
	@GetMapping("/all")
	public List<Employee> getAllEmployees()
	{
		return es.getAllEmployees();
	}
	
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable Long id,
			                         @RequestBody Employee employee)
	{
		return es.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		es.deleteEmployee(id);
		return "Employee deleted Succesfully ";
	}
	
	
	
	
}
