package in.main;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component // This tells Spring to create an instance of this class automatically
public class DeliveryScheduler {

    // Task 13: Run every 5 seconds (5000 milliseconds)
    @Scheduled(fixedRate = 5000)
    public void checkDeliveryUpdates() {
        System.out.println("Checking medicine delivery updates...");
    }
}