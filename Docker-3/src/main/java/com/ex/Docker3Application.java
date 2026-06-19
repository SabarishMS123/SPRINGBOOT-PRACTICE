package com.ex;
                                                                                         

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Docker3Application {
 
	
	 
	@GetMapping("/")
	public void demo()
	{
		System.out.println("Hello");
	}
	public static void main(String[] args) {
		SpringApplication.run(Docker3Application.class, args);
	}

}
