package com.tms.homework_42;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Value("${file.path}")
    private String path;

    private final static String file = "D:\\Courses\\TMS\\Homework_42\\src\\main\\java\\com\\tms\\homework_42\\";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Path filePath = Paths.get(file + path);

        String count;

        if (Files.exists(filePath)) {
            String str = Files.readString(filePath);
            count = String.valueOf(Integer.parseInt(str) + 1);
        } else {
            Files.createFile(filePath);
            count = "1";
        }

        try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {

            byte[] buffer = count.getBytes();
            fos.write(buffer, 0, buffer.length);

        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
