package in.sp.main.handler;

// 
//import org.springframework.http.HttpStatus;
//import org.springframework.web.ErrorResponse;
//import org.springframework.web.bind.annotation.*;
//
//import in.sp.main.exception.FoodNotAvailableException;

 
//@RestControllerAdvice// handles excep mainly like a manager
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(FoodNotAvailableException.class)// user defined exception class is called over here
//    
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ErrorResponse handleFoodException(FoodNotAvailableException ex) {
//        return new ErrorResponse(ex.getMessage(), 404);
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorResponse handleGeneralException(Exception ex) {
//        return new ErrorResponse("Something went wrong", 500);
//    }
//}



import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;
import in.sp.main.exception.FoodNotAvailableException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FoodNotAvailableException.class)
    public ProblemDetail handleFoodException(FoodNotAvailableException ex) {
        // ProblemDetail is the built-in way to return errors in Spring Boot 3
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGeneralException(Exception ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong");
    }
}
 