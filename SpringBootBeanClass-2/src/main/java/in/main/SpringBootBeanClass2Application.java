package in.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBeanClass2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeanClass2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		trees().displayTrees();
		trees1().displayTrees();

	}
	@Bean
	public Trees trees()
	{
		return new Trees("Azhadiracta Indica" , " Neem Tree" ,123);
	}
 
	@Bean
	public Trees trees1()
	{
		return new Trees("Tomata Linda" , " tomato" ,129);
	}

}
