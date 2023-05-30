package com.example.demo_springboot.controller;

import com.example.demo_springboot.domain.FormField;
import com.example.demo_springboot.services.NhanVienService;
import com.example.demo_springboot.services.NsxService;
import com.example.demo_springboot.services.TemplateService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class test {
    @Autowired
    private Map<String, TemplateService> serviceMap;


    @SneakyThrows
    @Transactional
    @GetMapping("/curd/{entityName}")
    public String handleRequest(@PathVariable String entityName,Model model) {
        Class<?> clazz = Class.forName("com.example.demo_springboot.domain."+entityName);
        List<Field> fields = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                fields.add(field);
                labels.add(field.getAnnotation(FormField.class).label());
            }
            clazz = clazz.getSuperclass();
        }
        TemplateService service = serviceMap.get(entityName);
        for (String key : serviceMap.keySet()) {
            System.out.println(key);
        }
        System.out.println(serviceMap.size());
        if (service == null) {
            return "Invalid entity name: " + entityName;
        }
        List<?> list = service.findAll();
        model.addAttribute("fieldsOfData",fields);
        model.addAttribute("labels",labels);
        model.addAttribute("listDatas",list);
        return "handle";
    }


}