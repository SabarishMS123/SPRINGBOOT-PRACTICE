package com.demo.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.main.entity.User;
import com.demo.main.repository.DbOperations;

@SpringBootApplication
public class Hibernateinspringtool1Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Hibernateinspringtool1Application.class, args);
		
		DbOperations dbop=context.getBean(DbOperations.class);
		User user=dbop.getUserDetails(1);
		if(user !=null) {
			System.out.println(user.getName());
			System.out.println(user.getEmail());
		}
		else
		{
			System.out.print("user not found");
		}
		
		
	}

}
