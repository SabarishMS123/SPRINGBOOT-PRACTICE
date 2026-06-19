package com.demo.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.main.dao.UserDao;
import com.demo.main.entity.User;

@SpringBootApplication
public class JdbcprojectApplication implements CommandLineRunner
{
	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//////////////////////////// insert ///////////////////////////////
//		User user1=new User("ram","salem","ram@gmail.com",1);
//		user1.setId(1);
//		user1.setName("ram");
//		user1.setEmail("ram@gmail.com");
//		user1.setAddress("salem");
//		
//		boolean status=userDao.insertUser(user1);
//		if(status) {
//			System.out.println("value inserted successfully");
//		}
//		else {
//			System.out.println("user not inserted due to some error");
//		}
		
		/////////////////////// update///////////////////////////////
//		User userToUpdate = new User("ramesh", "bangalore", "ramesh_updated@gmail.com", 1); 
//		boolean updateStatus = userDao.updateUser(userToUpdate);
//		if(updateStatus) {
//			System.out.println("User updated successfully: " + userToUpdate.getName() + " (ID: " + userToUpdate.getId() + ")");
//		} else {
//			System.out.println("User not updated. Check if user with ID " + userToUpdate.getId() + " exists or for other errors.");
//		}
		
		////////////////////////// delete ///////////////////////////////////////////////////////////
		
//		int userIdToDelete = 1; 
//		boolean deleteStatus = userDao.deleteUser(userIdToDelete);
//		if(deleteStatus) {
//			System.out.println("User deleted successfully: ID " + userIdToDelete);
//		} else {
//			System.out.println("User not deleted. Check if user with ID " + userIdToDelete + " exists or for other errors.");
//		}
//		
		
//		/////////////////////////// select //////////////////////////////////////
//		
//		User user=userDao.getUserByEmail("ram@gmail.com");
//		System.out.println("ID :"+user.getId());
//		System.out.println("Nanem :"+user.getName());
//		System.out.println("Nanem :"+user.getEmail());
//		System.out.println("Nanem :"+user.getAddress());
		
	/////////////////////////// select all user//////////////////////////////////////
		
//		List<User> list=userDao.getAllUser();
//		for(User user:list) {
//		System.out.println("ID :"+user.getId());
//		System.out.println("Nanem :"+user.getName());
//		System.out.println("Nanem :"+user.getEmail());
//		System.out.println("Nanem :"+user.getAddress());
//		}
		
		
		////// update selected value /////////////////////////////////////
		
		User user=userDao.getUserByEmail("ram@gmail.com");
		user.setAddress("erode");
		boolean updateStatus = userDao.updateUser(user);
		if(updateStatus) {
			System.out.println("User updated successfully: " + user.getName() + " (ID: " + user.getId() + ")");
		} else {
			System.out.println("User not updated. Check if user with ID " + user.getId() + " exists or for other errors.");
		}
		
		
		

	}

}
