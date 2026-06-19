package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@Controller
public class Mycontroller {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String openRegPage(Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute ("user") User user,Model model)
	{
		
		boolean status=userService.registerUser(user);
		if(status)
		{
			model.addAttribute("successMsg","user reg success");
		}
		else
		{
			model.addAttribute("errorMsg","user reg not success");
			
		}
		return "register";
	}

}
