package com.demo.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.main.entities.Student;
import com.demo.main.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public boolean addStudentDetails(Student std) {
		// TODO Auto-generated method stub
		
		boolean status=false;
		try {
			
			studentRepository.save(std);
			status=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status=false;
		}
		
		
		return status;
	}

	@Override
	public List<Student> getAllStdDetails() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student getStdDetails(int id) {
		Optional<Student> optional=studentRepository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
			
		}
		else {
		return null;
		}
	}

	@Override
	public boolean updateStdDetails(int id, int age) {
		// TODO Auto-generated method stub
		
		Student std=getStdDetails(id);
		if(std!=null)
		{
			std.setAge(age);
			studentRepository.save(std);
		}
		return false;
	}

	@Override
	public boolean deleteStdDetails(int id) {
		// TODO Auto-generated method stub
		
		boolean status=false;
		try {
			studentRepository.deleteById(id);
			status=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status=false;
		}
		return status;
	}

	

	

}
