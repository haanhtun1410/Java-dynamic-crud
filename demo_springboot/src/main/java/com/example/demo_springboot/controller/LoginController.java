package com.example.demo_springboot.controller;

import com.example.demo_springboot.domain.ChiTietSp;
import com.example.demo_springboot.domain.GioHang;
import com.example.demo_springboot.domain.GioHangChiTiet;
import com.example.demo_springboot.domain.KhachHang;
import com.example.demo_springboot.repos.GioHangChiTietRepository;
import com.example.demo_springboot.repos.GioHangRepository;
import com.example.demo_springboot.services.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    HttpSession session;

    @Autowired
    GioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    GioHangRepository gioHangRepository;


    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("")
    private String detail(){
        return "login";
    }
    @GetMapping("/logout")
    private String logout(){
        session.removeAttribute("invoice");
        session.removeAttribute("listItems");
        session.setAttribute("LoggedAccount",null);
        session.setAttribute("cart",null);
        return "login";
    }

    @PostMapping("/log")
    private String login(@RequestParam("username") String username,@RequestParam("password") String password){
        KhachHang kh = khachHangService.getByUserName(username,password);
        if(kh.getId().equals(null)){
            return "error";
        }
        else{
            session.setAttribute("LoggedAccount",kh);
            GioHang cart = gioHangRepository.getGioHangByIdKH(kh);
           if (cart == null){
               gioHangRepository.save(new GioHang(kh,"GH"+kh.getMa(),1));
           }
            session.setAttribute("cart",gioHangRepository.getGioHangByIdKH(kh));
            List<GioHangChiTiet> listItems =  gioHangChiTietRepository.findAllById_IdGioHang(gioHangRepository.getGioHangByIdKH(kh).getId());
            session.setAttribute("listItems",listItems);
            return "redirect:http://localhost:8080/main-page";
        }
    }
}
