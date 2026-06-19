package com.demo.main.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.demo.main.config.HibernateConfig;
import com.demo.main.entity.User;

@Repository
public class DbOperationsImpl implements DbOperations {
	
	

	@Override
	public User getUserDetails(int id) {
		// TODO Auto-generated method stub
		User user=null;
		
		try (
				Session session=HibernateConfig.getSessionFactory().openSession();
			)
		{
			user=session.get(User.class,id);
//			user.getAddress();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}

}
