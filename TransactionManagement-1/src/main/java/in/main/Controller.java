package in.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class Controller {
        @Autowired
        private EmployeeService empService;
        
        @PostMapping("/add")
        public ResponseEntity<Employee> saveEmployee(@RequestBody Employee empp) throws Exception{
		  Employee employeeSaveToDB =this.empService.addEmp(empp);	
          	return new ResponseEntity<Employee>(employeeSaveToDB,HttpStatus.CREATED);
        	
        }
}
