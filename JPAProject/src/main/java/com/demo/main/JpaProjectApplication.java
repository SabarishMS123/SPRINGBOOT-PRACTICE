package com.demo.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.main.entities.Student;
import com.demo.main.services.StudentService;
import com.demo.main.services.StudentServiceImpl;

@SpringBootApplication
public class JpaProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(JpaProjectApplication.class, args);
		
		StudentService stdService=context.getBean(StudentServiceImpl.class);
		
		// Insert value in table
		
//		Student std=new Student();
//		std.setAddress("salem");
//		std.setAge(12);
//		std.setName("ram");
//		
//		boolean status=stdService.addStudentDetails(std);
//		if(status)
//		{
//			System.out.println("Student inserted Successfully");
//		}
//		else
//		{
//			System.out.println("Student not inserted Successfully");
//		}
		
		// Select value from table
		
//		List<Student> stdList=stdService.getAllStdDetails();
//		for(Student std: stdList)
//		{
//			System.out.println("Id :"+std.getId());
//			System.out.println("Name :"+std.getName());
//			System.out.println("Address :"+std.getAddress());
//			System.out.println("Age :"+std.getAge());
//			
//			
//		}
		
		// select value by id
		
//		Student std=stdService.getStdDetails(1);
//		
//		if(std!=null) {
//		
//			System.out.println("Id :"+std.getId());
//			System.out.println("Name :"+std.getName());
//			System.out.println("Address :"+std.getAddress());
//			System.out.println("Age :"+std.getAge());
//		}
//		else
//		{
//			System.out.println("Student not found");
//		}
		
		// update value 
		
//		boolean status=stdService.updateStdDetails(1, 20);
//		if(status)
//		{
//			System.out.println("value updated");
//		}
//		else {
//			System.out.println("value not updated");
//		}
		
		// delet value
		
		boolean status=stdService.deleteStdDetails(1);
		if(status)
		{
			System.out.println("value deleted");
		}
		else {
			System.out.println("value not deleted");
		}

	}

}
