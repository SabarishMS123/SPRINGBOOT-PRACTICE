package in.main.employeecontroller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//it should come inside the constructor
@RestController
public class EmployeeController{
ArrayList<Integer>z;
public EmployeeController(){
 		z=new ArrayList<Integer>();
		z.add(20);
		z.add(40);
		z.add(60);
	}



@PutMapping("/change/{id}")
public void  change(@PathVariable int id) {
	
	System.out.println(z);
	z.remove(id);
	z.add(id,100);
	System.out.println(z);
	
}






//@RestController
//@RequestMapping("/apis")
//public class EmployeeController {
//	@GetMapping("/get")
//	public String getMessage() {
//		return "Your request has been processed well...";
//		
//	}
//	
//    
//	@PostMapping("/post")
//	public String postMessage(@RequestBody String name) {
//		return " User Name is :"+name;
//		
//	}
//	
 

}