package in.main.Scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	
	
	//this is for extracting the scheduling task in the program
	@Scheduled(fixedDelay=5000)
		//this fixedDelay is to perform task within set of time interval 
		
		public void ScheduleTasks() {
			SimpleDateFormat d=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
			//here u have to mention the date format like date, time (i have mentioned here including milliseconds)
			String forms=d.format(new Date());
			
			System.out.println("Now Server running at the time "+forms);
		}
	}


