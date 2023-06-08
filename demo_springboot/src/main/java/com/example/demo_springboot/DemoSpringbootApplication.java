package com.example.demo_springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class DemoSpringbootApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        // Open the browser with the desired URL
        String url = "http://localhost:8080/main-page";
        String uri = "http://localhost:8080/api/curd/NhanVien";
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(url));
        }
    }
}
