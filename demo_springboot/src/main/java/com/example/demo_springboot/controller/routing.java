package com.example.demo_springboot.controller;

import com.example.demo_springboot.domain.ChiTietSp;
import com.example.demo_springboot.services.ChiTietSpService;
import com.example.demo_springboot.services.TemplateService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/main-page")
public class routing {
    @Autowired
    HttpSession session;

    @Autowired
    ChiTietSpService chiTietSpService;

    @Autowired
    @Qualifier("getEntity")
    List<String> classList;

    @RequestMapping("")
    public String home(){
        session.setAttribute("classList",classList);
        List<ChiTietSp> chiTietSps = chiTietSpService.findAll();
        if (chiTietSps.size() > 8) {
            // Return only the first 8 records
            chiTietSps = chiTietSps.subList(0, 8);
        }
        session.setAttribute("AssestsProduct",chiTietSps);

        return "main";
    }
}
