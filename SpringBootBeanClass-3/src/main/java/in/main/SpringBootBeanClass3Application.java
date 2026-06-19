package in.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"in.main", "in.config"})
public class SpringBootBeanClass3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeanClass3Application.class, args);
	}

}
