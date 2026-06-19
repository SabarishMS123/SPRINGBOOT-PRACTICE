package com.demo.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/register")
	public String openRegPage()
	{
		
		return "register";
		
	}

}
