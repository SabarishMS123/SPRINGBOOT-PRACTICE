package com.demo.main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.main.dao.UserDao;
import com.demo.main.entity.User;

@SpringBootApplication
public class JdbcmineApplication implements CommandLineRunner {
 
	  @Autowired
	  private UserDao userDao;
	  
	public static void main(String[] args) {
		SpringApplication.run(JdbcmineApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user=userDao.getUserbyEmail("ram@gmail.com");
		user.setAddress("Trichy");
		boolean updateStatus = userDao.updateUser(user);
		if(updateStatus) {
			System.out.println("User updated successfully: " + user.getName() + " (ID: " + user.getId() + ")");
		} else {
			System.out.println("User not updated. Check if user with ID " + user.getId() + " exists or for other errors.");
		}
	}
	}


