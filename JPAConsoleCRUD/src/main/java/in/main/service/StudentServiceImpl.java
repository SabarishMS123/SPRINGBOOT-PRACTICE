package in.main.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.main.entity.Student;
import in.main.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public StudentRepository s;

	@Override
	public boolean addStudentDetails(Student std) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			s.save(std);
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		
		return status;
	}

	@Override
	public List<Student> getAllStdDetails() {
		// TODO Auto-generated method stub
		
		return s.findAll();
	}

	@Override
	public Student getStdDetails(long id) {
		// TODO Auto-generated method stub
		Optional<Student>optional=s.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
		
	}

	@Override
	public boolean updateStdDetails(long id, float marks) {
		// TODO Auto-generated method stub
		Student std = getStdDetails(id);
		if(std!=null) {
			std.setMarks(marks);
			s.save(std);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStdDetails(long id) {
		// TODO Auto-generated method stub
		boolean status=false;
		try {
			s.deleteById(id);
			status=true;
			
		}catch(Exception e){
			e.printStackTrace();
			status=false;
		}
		return status;
	}
	

}
