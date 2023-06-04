package com.example.demo_springboot.controller;

import com.example.demo_springboot.domain.FormField;
import com.example.demo_springboot.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

@Controller
@RequestMapping("/test")
public class test {

    @Autowired
    private Map<String, TemplateService> serviceMap;

    @Autowired
    HttpSession session;

    @SneakyThrows @Transactional
    @GetMapping("/curd/{entityName}")
    public String handleRequest(@PathVariable String entityName) {
        Class<?> clazz = Class.forName("com.example.demo_springboot.domain."+entityName);
        List<Field> fields = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        Map<String ,String> metaData = new LinkedHashMap<>();
        Map<String ,List> listInner = new LinkedHashMap<>();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                fields.add(field);
                if(field.getAnnotation(FormField.class).type().getInputType().compareTo("select")==0){
                   listInner.put(field.getType().getSimpleName(),serviceMap.get(field.getType().getSimpleName()).findAll());
                }
                labels.add(field.getAnnotation(FormField.class).label());
                metaData.put(field.getAnnotation(FormField.class).label(),field.getAnnotation(FormField.class).type().getInputType());
            }
        TemplateService service = serviceMap.get(entityName);
        if (service == null) {
            return "Invalid entity name: " + entityName;
        }
        List<?> list = service.findAll();
        if(listInner.size()>0){
            session.setAttribute("listOfListInner",listInner);
        }
        session.setAttribute("fieldsOfData",fields);
        session.setAttribute("labels",labels);
        session.setAttribute("listDatas",list);
        session.setAttribute("typeInputs",metaData);
        session.setAttribute("entity",entityName);
        return "handle";
    }

    @SneakyThrows
    @PostMapping("/curd/{entity}/add")
    public String save(@PathVariable("entity") String entityName, @RequestParam Map<String, Object> formData) {
        for(Map.Entry e : formData.entrySet()){
            System.out.println(e.getKey() + " " +e.getValue());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Object oke = objectMapper.convertValue(formData, Class.forName("com.example.demo_springboot.domain."+entityName).getDeclaredConstructor().newInstance().getClass());
        System.out.println(oke);
        System.out.println(oke.getClass());
        serviceMap.get(entityName).save(oke);
        return "redirect:/test/curd/"+entityName;
    }

    @SneakyThrows
    @RequestMapping("/curd/{entity}/delete/{id}")
    public String delete(@PathVariable("entity") String entityName,@PathVariable("id") String id){
        TemplateService service = serviceMap.get(entityName);
        service.delete(UUID.fromString(id));
        return "redirect:/test/curd/"+entityName;
    }

    @RequestMapping("/curd/{entity}/detail/{id}")
    public String detail(@PathVariable("entity") String entityName,@PathVariable("id") String id){
        TemplateService service = serviceMap.get(entityName);
        System.out.println(service.findById(UUID.fromString(id)));
        session.setAttribute("detailEntity",service.findById(UUID.fromString(id)));
        return "update-form";
    }
}

//1controller for every entity in my db