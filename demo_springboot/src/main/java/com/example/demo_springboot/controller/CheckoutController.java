package com.example.demo_springboot.controller;


import com.example.demo_springboot.domain.*;
import com.example.demo_springboot.repos.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

        @Autowired
        HttpSession session;

        @Autowired
        GioHangChiTietRepository gioHangChiTietRepository;

        @Autowired
        GioHangRepository gioHangRepository;

        @Autowired
        HoaDonRepository hoaDonRepository;
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

        @Autowired
        private ChiTietSpRepository chiTietSpRepository;

        @GetMapping("")
        @Transactional
        public String detail(Model md, @SessionAttribute("cart") GioHang gioHang, @SessionAttribute("LoggedAccount") KhachHang khachHang){
         HoaDon hd = hoaDonRepository.findByidKHAndTinhTrang(khachHang,0);
         if(hd == null){
             hd = new HoaDon();
             hd.setMa("HDKH"+hoaDonRepository.count());
             hd.setIdKH(khachHang);
             hd.setTinhTrang(0);
             hd.setNgayTao(LocalDate.now());
                 hoaDonRepository.save(hd);
                 session.setAttribute("invoice",hd);
         }
         else{
                 session.setAttribute("invoice",hd);
         }
         return "checkout";
        }

        @PostMapping("/submit")
        @Transactional
        public String submit(@RequestParam("name") String name,
                             @RequestParam("address") String address,
                             @RequestParam("sdt") String sdt, @SessionAttribute("cart") GioHang gioHang,
                             @SessionAttribute("LoggedAccount") KhachHang khachHang,
                             @SessionAttribute("listItems") List<GioHangChiTiet> listGH,
                             @SessionAttribute("invoice") HoaDon hd){
            for(GioHangChiTiet x: listGH){
                HoaDonChiTietId hoaDonChiTietId = new HoaDonChiTietId();
                hoaDonChiTietId.setIdHoaDon(hd.getId());
                hoaDonChiTietId.setIdChiTietSP(x.getId().getIdChiTietSP());
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setDonGia(x.getDonGia());
                hoaDonChiTiet.setSoLuong(x.getSoLuong());
                hoaDonChiTiet.setId(hoaDonChiTietId);
                hoaDonChiTietRepository.save(hoaDonChiTiet);
            }
            gioHangChiTietRepository.deleteAllById_IdGioHang(gioHang.getId());
           gioHangRepository.delete(gioHang);
            hd.setTenNguoiNhan(name);
            hd.setDiaChi(address);
            hd.setNgayThanhToan(LocalDate.now());
            hd.setSdt(sdt);
            hd.setTinhTrang(1);
            hoaDonRepository.save(hd);
            session.removeAttribute("gioHang");
          return "success";
        }
}
