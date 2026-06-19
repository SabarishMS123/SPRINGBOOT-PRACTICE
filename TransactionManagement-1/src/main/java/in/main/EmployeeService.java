package in.main;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
   @Autowired
   private EmployeeRepository er;
   
   @Transactional
   public Employee addEmp(Employee emp) throws Exception {
	   Employee saveemp=this.er.save(emp);
	   return saveemp;
   }
}
