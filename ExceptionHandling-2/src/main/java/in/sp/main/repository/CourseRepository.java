package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.Course;
 
public interface CourseRepository extends JpaRepository<Course, Long> {
}