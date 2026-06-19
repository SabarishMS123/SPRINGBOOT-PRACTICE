package in.main.Scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulingSpringBootclass2Application {

	public static void main(String[] args) {
		SpringApplication.run(SchedulingSpringBootclass2Application.class, args);
	}

}
