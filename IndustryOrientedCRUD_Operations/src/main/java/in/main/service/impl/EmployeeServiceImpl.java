package in.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.entity.Employee;
import in.main.repository.EmployeeRepository;
import in.main.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService {

	@Autowired
	private EmployeeRepository er;
	
	 
	
	@Override
	public Employee saveEmployee(Employee employee) {
	    
		return er.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return er.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		// TODO Auto-generated method stub
		
		Employee ex = er.findById(id).orElse(null);
		ex.setName(employee.getName());
		ex.setDepartment(employee.getDepartment());
		ex.setSalary(employee.getSalary());
		return er.save(ex);
	}

	@Override
	public void deleteEmployee(Long id) {
		er.deleteById(id);
		
	}

}
