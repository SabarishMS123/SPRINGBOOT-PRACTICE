package in.sp.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.dto.CourseDto;
import in.sp.main.entity.Course;
import in.sp.main.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    // Get all courses (Entity -> DTO)
    public List<CourseDto> getAllCourses() {

        List<Course> courses = repo.findAll();

        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
    }

    // Get single course
    public CourseDto getCourseById(Long id) {

        Course course = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return modelMapper.map(course, CourseDto.class);
    }
    
    
    public CourseDto addCourse(CourseDto courseDto) {
        
        // DTO → Entity
        Course course = modelMapper.map(courseDto, Course.class);
        
        // Save to DB
        Course savedCourse = repo.save(course);
        
        // Entity → DTO
        return modelMapper.map(savedCourse, CourseDto.class);
    }
}
