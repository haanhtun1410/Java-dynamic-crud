package com.example.demo_springboot.controller;

import com.example.demo_springboot.model.KhachHang;
import com.example.demo_springboot.model.NhanVien;
import jakarta.validation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {
    private List<KhachHang> khachHangList = new ArrayList<>();
    static long id = 3L;

    {
        KhachHang khachHang1 = new KhachHang(1, "KH001", "John Doe", new Date(), "1234567890", "123 Main Street", "New York", "USA", "password123");
        khachHangList.add(khachHang1);

        // Creating instance 2 using constructor
        KhachHang khachHang2 = new KhachHang(2, "KH002", "Jane Smith", new Date(), "9876543210", "456 Elm Street", "Los Angeles", "USA", "password456");
        khachHangList.add(khachHang2);

        // Creating instance 3 using constructor
        KhachHang khachHang3 = new KhachHang(3, "KH003", "Alex Johnson", new Date(), "5555555555", "789 Oak Street", "Chicago", "USA", "password789");
        khachHangList.add(khachHang3);

    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("khachHangList",this.khachHangList);
        return "khach-hang";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("khachHang",new KhachHang());
        return "create-kh";
    }

    @PostMapping("/add")
    public String store(@Valid @ModelAttribute KhachHang khachHang, @RequestParam String date , BindingResult result){
        if (result.hasErrors()) {
            return "khach-hang/create";
        }else{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date ngaySinh = null;
            System.out.println(date);
            try {
                ngaySinh = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setId(id++);
            this.khachHangList.add(khachHang);
            return "redirect:/khach-hang";
        }
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        for(KhachHang khachHang : this.khachHangList){
            if(khachHang.getId() == Long.valueOf(id)){
                this.khachHangList.remove(khachHang);
                break;
            }
        }
        return "redirect:/khach-hang";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @ModelAttribute("khachHang") KhachHang kh, @RequestParam String date) {
        for (KhachHang khachHang : this.khachHangList) {
            if (khachHang.getId() == Long.valueOf(id)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date ngaySinh = null;
                System.out.println(date);
                try {
                    ngaySinh = dateFormat.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                kh.setNgaySinh(ngaySinh);
                this.khachHangList.set(this.khachHangList.indexOf(khachHang), kh);
                break;
            }
        }
        return "redirect:/khach-hang";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") String id) {
        for (KhachHang khachHang : this.khachHangList) {
            if (khachHang.getId() == Long.valueOf(id)) {
                model.addAttribute("khachHang", khachHang);
                Date date = khachHang.getNgaySinh();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = sdf.format(date);
                model.addAttribute("date2", formattedDate);
                break;
            }
        }
        return "edit-kh";
    }

}
