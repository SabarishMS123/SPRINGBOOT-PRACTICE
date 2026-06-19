package in.main;

import java.io.File;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource; // Correct Resource import
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/files")
public class FileController {
      private static final String Upload_path ="E:\\MYfolderyeyy\\";
      @PostMapping("/uploadFile")
      public String uploadFile(@RequestParam("Files") MultipartFile file) {
//    	  MultipartFile class is used for file Uploading in java
    	  try {
    	  File dir=new File(Upload_path);
    	  if(!dir.exists()) {
    		  dir.mkdir();
    	  }
    	  String file_path=Upload_path+file.getOriginalFilename();
    	  file.transferTo(new File(file_path));
    	  return "File uploaded successfully.."+file.getOriginalFilename();
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    		  System.out.println("File Name: "+file.getOriginalFilename());
    		  return "File not found";
    	  }
    	  
    	  
}
      
      @DeleteMapping("/delete/{fileName}")
      public String deleteFile(@PathVariable("fileName") String fileName) { 
          
          File file = new File(Upload_path + fileName); 
          
          if (file.exists()) {
              if (file.delete()) {
                  return "File Deleted Successfully: " + fileName;
              } else {
                  return "File exists but could not be deleted (it might be in use by another process).";
              }
          } else {
              return "No such file exists at path: " + file.getAbsolutePath();
          }
      }
      
      @GetMapping("/download/{fileName}") // Fixed typo in "downlaod"
      public ResponseEntity<Resource> download(@PathVariable String fileName) {
          File file = new File(Upload_path + fileName);
          
          if (!file.exists()) {
              return ResponseEntity.notFound().build();
          }

          // Wrap the file in a Spring Resource
          Resource resource = new FileSystemResource(file);

          return ResponseEntity.ok()
                  .contentType(MediaType.APPLICATION_OCTET_STREAM) // Tells browser it's a binary file
                  .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                  .body(resource);
      }
}
