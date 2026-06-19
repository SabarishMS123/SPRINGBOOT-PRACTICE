package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.Userrepository;
import com.example.demo.repositories.Userrepository;

@Service
public class UserServiceImple {
	@Autowired
	private Userrepository userRepository;

	
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		try {
			
			userRepository.save(user);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	
	public User loginUser(String email, String password) {
		// TODO Auto-generated method stub
		
		User validUser=userRepository.findByEmail(email);
		if(validUser != null && validUser.getPassword().equals(password))
		{
			return validUser;
		}
		return null;
	}
}
