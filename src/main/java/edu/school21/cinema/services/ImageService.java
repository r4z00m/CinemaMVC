package edu.school21.cinema.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;

@Service
public class ImageService {

    public void save(MultipartFile image) {
        File fileToUpload = new File("../webapps/Cinema/images/" + image.getOriginalFilename());
        try {
            fileToUpload.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedInputStream inputStream = new BufferedInputStream(image.getInputStream());
             BufferedOutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(fileToUpload.toPath()))) {
            while (inputStream.available() > 0) {
                outputStream.write(inputStream.read());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
