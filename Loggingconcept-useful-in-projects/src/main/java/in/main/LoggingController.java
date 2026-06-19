package in.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
    @RequestMapping("/api")
    public String loggoff() {
    	  logger.debug("Hii , inbuild functions are altered..");
    	  logger.info("Oops shattered..");
    	  logger.warn("Breached the limits !");
    	  logger.error("Fatal error occured..!");
    	  return "loggerFactory";
    }
}
