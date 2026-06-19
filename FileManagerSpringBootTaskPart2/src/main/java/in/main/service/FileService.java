package in.main.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FileService {

    @Transactional
    public void saveFileDetails(String filename) {

        System.out.println("Saving file info to DB: " + filename);

        // Simulate error
        if (true) {
            throw new RuntimeException("Error while saving!");
        }
    }
}
