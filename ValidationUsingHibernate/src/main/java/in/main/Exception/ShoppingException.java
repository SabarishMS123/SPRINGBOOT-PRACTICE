package in.main.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShoppingException {
 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public Map<String,String> handleValidationException(MethodArgumentNotValidException  m)
	 {
		 Map<String , String > errors = new HashMap<>();
		 m.getBindingResult().getFieldErrors().forEach(err->{
			 
			 errors.put(err.getField(),err.getDefaultMessage());
		 }
		             
		      
				  
				 );
		 return errors;
	 }
}
