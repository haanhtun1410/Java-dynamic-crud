package com.example.demo_springboot.config;


import com.example.demo_springboot.domain.ChiTietSp;
import com.example.demo_springboot.services.ChiTietSpService;
import com.example.demo_springboot.services.ChucVuService;
import com.example.demo_springboot.services.CuaHangService;

import com.example.demo_springboot.services.TemplateService;
import jakarta.servlet.http.HttpSession;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;
import java.util.*;

@Configuration
public class ServiceConfig {

    @Autowired
    private Map<String, TemplateService> serviceMap;

    @Autowired
    private HttpSession ss;

    @Autowired
    private ChiTietSpService chiTietSpService;

      @Bean("getEntity")
      List<String> getEntityList() {
          List<String> classList = new ArrayList<>();
          for (Map.Entry e : serviceMap.entrySet()) {
              classList.add(e.getKey().toString());
          }
          System.out.println(classList);
          return classList;
      }
}