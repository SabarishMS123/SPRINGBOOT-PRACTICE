package com.demo.main;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.demo.main.beans.Employee;

@SpringBootApplication
public class NextApplication  //implements CommandLineRunner
{
	

	public static void main(String[] args) {
		SpringApplication.run(NextApplication.class, args);
		System.out.println("Exiting Details!");
	}

	
	
}
