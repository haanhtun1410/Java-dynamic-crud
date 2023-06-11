package com.example.demo_springboot.controller;

import com.example.demo_springboot.domain.*;
import com.example.demo_springboot.repos.ChiTietSpRepository;
import com.example.demo_springboot.repos.GioHangChiTietRepository;
import com.example.demo_springboot.repos.GioHangRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/cart")
public class SellController {

    @Autowired
    HttpSession session;

    @Autowired
    GioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    GioHangRepository gioHangRepository;

     @Autowired
     private ChiTietSpRepository chiTietSpRepository;

    @ExceptionHandler(ServletRequestBindingException.class)
    public ModelAndView handleMissingSessionAttribute(ServletRequestBindingException ex) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("errorMessage", "Please login before shopping");
        return modelAndView;
    }


    @GetMapping("")
    @Transactional
    public String detail(@SessionAttribute("cart") GioHang gioHang){
        List<GioHangChiTiet> listItems =  gioHangChiTietRepository.findAllById_IdGioHang(gioHang.getId());
        List<ChiTietSp> items = new ArrayList<>();
       for( GioHangChiTiet x: listItems ){
           UUID id =  x.getId().getIdChiTietSP();
           ChiTietSp chiTietSp = chiTietSpRepository.findById(id).get();
           items.add(chiTietSp);
       }
       session.setAttribute("listItems",listItems);
       session.setAttribute("items",items);
        return "cart";
    }

    @GetMapping("/add/{spID}")
    @Transactional
    public String addToCard(@SessionAttribute("cart") GioHang gh, @PathVariable("spID") UUID idSp){
        GioHangChiTietId gioHangChiTietId = new GioHangChiTietId(gh.getId(),idSp);
        System.out.println(gioHangChiTietId);
        if(gioHangChiTietRepository.existsById(gioHangChiTietId)){
            GioHangChiTiet ghct = gioHangChiTietRepository.findById(gioHangChiTietId).get();
            ghct.setSoLuong(ghct.getSoLuong()+1);
           gioHangChiTietRepository.save(ghct);
        }else{
           GioHangChiTiet ghct = new GioHangChiTiet();
           ghct.setId(gioHangChiTietId);
           BigDecimal price = chiTietSpRepository.getById(idSp).getGiaBan();
           ghct.setDonGia(price);
           ghct.setSoLuong(1);
           ghct.setDonGiaKhiGiam(price);
           gioHangChiTietRepository.save(ghct);
           session.setAttribute("listItems",gioHangChiTietRepository.findAllById_IdGioHang(gh.getId()));
        }
        return "redirect:/shop";
    }

    @PostMapping("/add/quantity-change")
    @Transactional
    public String changeQuantity(@SessionAttribute("cart") GioHang kh,@RequestParam("idsp") UUID idsp,@RequestParam("idgh") UUID idgh, @RequestParam("quantity") int updateQuantity ){
   GioHangChiTietId id = new GioHangChiTietId(idgh,idsp);
        if(updateQuantity == 0){
            gioHangChiTietRepository.deleteById(id);
            session.setAttribute("listItems",gioHangChiTietRepository.findAllById_IdGioHang(kh.getId()));
        }else{
            gioHangChiTietRepository.updateValueById(id,updateQuantity);
        }
        return "redirect:/cart";
    }




}
