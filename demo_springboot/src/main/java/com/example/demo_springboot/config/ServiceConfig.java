package com.example.demo_springboot.config;


import com.example.demo_springboot.services.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.example.demo_springboot.services")
public class ServiceConfig {


    @Bean
    public Map<String, TemplateService> serviceMap() {
        Map<String, TemplateService> serviceMap = new HashMap<>();
        return serviceMap;
    }
}