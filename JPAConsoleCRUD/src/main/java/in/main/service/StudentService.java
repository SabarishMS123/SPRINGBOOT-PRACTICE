package in.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.main.entity.Student;

public interface StudentService {
	
       public boolean addStudentDetails(Student std);
       
       public List<Student>getAllStdDetails();
       
       public Student getStdDetails(long id);
       
       public boolean updateStdDetails(long id , float marks);
       
       public boolean deleteStdDetails(long id);
}
