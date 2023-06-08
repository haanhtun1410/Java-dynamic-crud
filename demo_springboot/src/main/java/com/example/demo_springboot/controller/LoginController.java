package com.example.demo_springboot.controller;

import com.example.demo_springboot.domain.KhachHang;
import com.example.demo_springboot.services.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("login")
public class LoginController {


    @Autowired
    HttpSession session;

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("")
    private String detail(){
        return "login";
    }
    @GetMapping("/logout")
    private String logout(){
        session.setAttribute("LoggedAccount",null);
        return "login";
    }

    @PostMapping("/log")
    private String login(@RequestParam("username") String username,@RequestParam("password") String password){
        System.out.println(username +" "+password);
        KhachHang kh = khachHangService.getByUserName(username,password);
        System.out.println(kh);
        if(kh.getId().equals(null)){
            return "error";
        }
        else{
            session.setAttribute("LoggedAccount",kh);
            return "redirect:http://localhost:8080/main-page";
        }
    }
}
