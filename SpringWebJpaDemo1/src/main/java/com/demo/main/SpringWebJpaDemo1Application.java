package com.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})

public class SpringWebJpaDemo1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebJpaDemo1Application.class, args);
	}
	
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		// TODO Auto-generated method stub
//		return builder.sources(SpringWebJpaDemo1Application.class);
//	}

}
