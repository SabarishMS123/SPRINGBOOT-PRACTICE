package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.dto.CourseDto;
import in.sp.main.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return service.getAllCourses();
    }
    

    @GetMapping("/{id}")
    public CourseDto getCourse(@PathVariable Long id) {
        return service.getCourseById(id);
    }
    
    @PostMapping
    public CourseDto addCourse(@RequestBody CourseDto courseDto) {
        return service.addCourse(courseDto);
    }
}

