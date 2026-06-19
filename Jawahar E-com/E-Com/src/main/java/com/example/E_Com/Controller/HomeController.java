package com.example.E_Com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class HomeController {
//								/ ← this symbol is mapping the page 
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	@GetMapping("/Login")
	public String Login(){
		return "Login";
	}
	
	
	@GetMapping("/Register")
	public String Register(){
		return "Register";
	}
	
	@GetMapping("/Product")
	public String product(){
		return "Product";
	}
	
	@GetMapping("/View_Product")
	public String View_Product(){
		return "View_Product";
	}
	@GetMapping("/Admin/index")
	public String adminIndex() {
		return "Admin/index";
	}

}
  