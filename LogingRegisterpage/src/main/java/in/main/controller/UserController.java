package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import in.sp.main.entity.User;
import in.sp.main.service.UserService;

@Controller
public class MyController {
	@Autowired
	private UserService userService;

	@GetMapping("/regPage")
	public String openRegPage(Model model) {
		model.addAttribute("user",new User());
		return "register";
	}
	
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user,Model model)
	{
		boolean status=userService.registerUser(user);
		if(status) {
			model.addAttribute("successmsg","User registered Successfully...");
		}
		else {
			model.addAttribute("errormsg","User not registered due to errors...");
		}
		return "register";
		
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("user",new User());
		return "login";
	}
	
	@PostMapping("/loginPage")
	public String submitLoginForm(@ModelAttribute("user") User user, Model model) {

	    User validUser = userService.loginUser(user.getEmail(), user.getPassword());

	    if(validUser != null) {
	        return "profile";  // success page
	    } else {
	        model.addAttribute("errormsg", "Email id and password didn't match...");
	        return "login";
	    }
	}
	
}
