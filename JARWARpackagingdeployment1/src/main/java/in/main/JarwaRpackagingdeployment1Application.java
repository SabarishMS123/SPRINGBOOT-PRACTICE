package in.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class JarwaRpackagingdeployment1Application {
    
    @GetMapping("/war")
    public String WarStarted() {
        return "War is going to start.";
    }
    
    public static void main(String[] args) {
        SpringApplication.run(JarwaRpackagingdeployment1Application.class, args);
    }
}