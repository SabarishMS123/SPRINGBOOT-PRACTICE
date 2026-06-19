package in.main;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
