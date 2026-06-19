package com.demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.main.entity.User;

@SpringBootApplication
public class Hibernateinspringtool1Application {

	public static void main(String[] args) {
		SpringApplication.run(Hibernateinspringtool1Application.class, args);
		
		Configuration cfg=new Configuration();
		cfg.configure("com/demo/main/config/hibernate.cfg.xml");
		SessionFactory sessionFactorty=cfg.buildSessionFactory();
		Session session=sessionFactorty.openSession();
		
		User user=session.get(User.class,1);
		System.out.println(user.getName());
		System.out.println(user.getAddress());
		
		
	}

}
