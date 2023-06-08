package com.example.demo_springboot.controller;

import com.example.demo_springboot.domain.ChiTietSp;
import com.example.demo_springboot.domain.DongSp;
import com.example.demo_springboot.services.ChiTietSpService;
import com.example.demo_springboot.services.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ChiTietSpService ctspSv;

    @Autowired
    DongSpService dongSpSv;


    @GetMapping("")
    public String index(Model md){
        md.addAttribute("list",ctspSv.findAll());
        md.addAttribute("listDSP",dongSpSv.findAll());
        return "shop";
    }
    @GetMapping("/{catagory}")
    public String sort(Model md, @PathVariable UUID catagory){
        List<ChiTietSp> list = ctspSv.findAll();
        md.addAttribute("list",ctspSv.findAllByDongSpId(catagory));
        md.addAttribute("listDSP",dongSpSv.findAll());
        return "shop";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model md,@PathVariable UUID id){
        md.addAttribute("list",ctspSv.findAll());
        md.addAttribute("detail",ctspSv.findById(id));
        return "detail";
    }

}
