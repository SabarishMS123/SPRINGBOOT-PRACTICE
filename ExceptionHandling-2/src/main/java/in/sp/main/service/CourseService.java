package in.sp.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.Course;
import in.sp.main.exception.CourseNotFoundException;
import in.sp.main.repository.CourseRepository;

@Service
public class CourseService {
	
	  @Autowired
	    private CourseRepository repo;

	    public Course getCourseById(Long id) {

	        Optional<Course> optional = repo.findById(id);

	        if (optional.isPresent()) {
	            return optional.get();
	        } else {
	            throw new CourseNotFoundException("Course not found with ID: " + id);
	        }
	    }
	    
	    
	    public Course saveCourse(Course course) {
	        return repo.save(course);
	    }

}
