package in.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBeanClass1Application implements CommandLineRunner {
	//commandLineRunner to perform an additional tasks 
	
//	spring application context is initialized and execute all out code after this initialization

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeanClass1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
       trees().display("Sabarish");
	}
	@Bean
	public Trees trees(){
		return new Trees();
	}

}
