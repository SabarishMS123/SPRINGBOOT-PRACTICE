package in.main.controller;

import in.main.Model.FileResponse;
import in.main.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;

@RestController
@RequestMapping("/files")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private final String UPLOAD_DIR = "C:/uploads/";

    @Autowired
    private FileService fileService;

    // ===================== UPLOAD =====================
    @PostMapping("/upload")
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            logger.info("File upload started: {}", file.getOriginalFilename());

            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) dir.mkdirs();

            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(path, file.getBytes());

     
            try {
                fileService.saveFileDetails(file.getOriginalFilename());
            } catch (Exception e) {
                logger.error("Transaction failed", e);
            }

           
            return new FileResponse(
                    file.getOriginalFilename(),
                    "Uploaded Successfully"
            );

        } catch (Exception e) {
            logger.error("Upload failed", e);

            return new FileResponse(
                    file.getOriginalFilename(),
                    "Upload Failed"
            );
        }
    }

    // ===================== DOWNLOAD =====================
    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        try {
            Path path = Paths.get(UPLOAD_DIR + filename);
            Resource resource = new UrlResource(path.toUri());

            if (!resource.exists()) {
                logger.warn("File not found: {}", filename);
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .body(resource);

        } catch (Exception e) {
            logger.error("Download error", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    // ===================== DELETE =====================
    @DeleteMapping("/delete/{filename}")
    public String deleteFile(@PathVariable String filename) {

        try {
            Path path = Paths.get(UPLOAD_DIR + filename);
            Files.deleteIfExists(path);

            return "File Deleted Successfully";

        } catch (Exception e) {
            logger.error("Error while deleting file", e);
            return "Delete Failed";
        }
    }
}