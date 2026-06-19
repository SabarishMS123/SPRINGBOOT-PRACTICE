package in.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/auth")
public class MyController {
	
	@GetMapping("/hello")
	public String hello() {
		return " Hello saboo , welcome to heaven ";
	}

}
