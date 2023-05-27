package com.example.demo_springboot.controller;

import com.example.demo_springboot.services.NhanVienService;
import com.example.demo_springboot.services.NsxService;
import com.example.demo_springboot.services.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/test")
public class test {
    @Autowired
    private Map<String, TemplateService> serviceMap;

    @Autowired
    private NsxService nhanVienService;

    @GetMapping("/curd/{entityName}")
    public String handleRequest(@PathVariable String entityName) {
        TemplateService service = serviceMap.get(entityName);
        for (String key : serviceMap.keySet()) {
            System.out.println(key);
        }
        System.out.println(serviceMap.size());
        if (service == null) {
            return "Invalid entity name: " + entityName;
        }
        // Call the method on the service
        System.out.println(service.findAll());;

        // Handle the request and return the response
        return "handle";
    }

    @GetMapping("/nv")
    public String index(Model model){
        System.out.println(this.nhanVienService.findAll());
        return "handle";
    }

}