 package com.demo.main.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.main.beans.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public CommandLineRunner cmdLineRunner()
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				stdBean().display();
				
				
			}
		};
	}
	
	@Bean
	public Employee stdBean()
	{
		return new Employee("Ram",1,"salem");
	}

}
