package com.demo.main.services;

import java.util.List;

import com.demo.main.entities.Student;

public interface StudentService {
	
	//insert
	public boolean addStudentDetails(Student std);
// get
	public List <Student> getAllStdDetails();
	public Student getStdDetails(int id);
	
	//update
	public boolean updateStdDetails(int id,int age);
	
	// delete
	
	public boolean deleteStdDetails(int id);

}
