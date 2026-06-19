package in.sp.main.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Handle specific CourseNotFoundException
    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleCourseNotFound(CourseNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", "Not Found");
        errorMap.put("message", ex.getMessage());
        return errorMap;
    }

    // 2. Modified General Exception Handler to give you MORE detail
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleGeneralException(Exception ex) {
        // Log the error to your IDE console so you can see the root cause
        ex.printStackTrace(); 
        
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", "Internal Server Error");
        errorMap.put("message", ex.getMessage()); // This will tell you if it's a DB issue
        return errorMap;
    }
}