package in.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JarwaRpackagingdeploymentApplication {

	
	@GetMapping("/war")
	public String WarStarted(String message) {
		message="War is going to start.";
		return message;
	}
	public static void main(String[] args) {
		SpringApplication.run(JarwaRpackagingdeploymentApplication.class, args);
	}

}
