package in.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class MedicineDeliveryApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MedicineDeliveryApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Medicine delivery started!!");
	    med().display();
		
	}
	
	@Bean 
	public DeliveryService med() {
		return new DeliveryService();
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
