package com.example.demo_springboot.controller;

import com.example.demo_springboot.model.CuaHang;
import com.example.demo_springboot.model.NhanVien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVIenController {

    private ArrayList<NhanVien> nhanVienList = new ArrayList<>();
    static Long id = 6L;

    {
        NhanVien nhanVien1 = new NhanVien(1L,"NV001", "John Doe", "Male", new Date(), "123 Main St", "1234567890", "password1", 1);
        NhanVien nhanVien2 = new NhanVien(2L,"NV002", "Jane Smith", "Female", new Date(), "456 Elm St", "0987654321", "password2", 1);
        NhanVien nhanVien3 = new NhanVien(3L,"NV003", "Robert Johnson", "Male", new Date(), "789 Oak St", "9876543210", "password3", 1);
        NhanVien nhanVien4 = new NhanVien(4L,"NV004", "Emily Davis", "Female", new Date(), "321 Pine St", "0123456789", "password4", 1);
        NhanVien nhanVien5 = new NhanVien(5L,"NV005", "Michael Brown", "Male", new Date(), "654 Cedar St", "5678901234", "password5", 1);
        nhanVienList.add(nhanVien1);
        nhanVienList.add(nhanVien2);
        nhanVienList.add(nhanVien3);
        nhanVienList.add(nhanVien4);
        nhanVienList.add(nhanVien5);
        System.out.println(nhanVien1.getNgaySinh());
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("nhanVienList",this.nhanVienList);
        return "nhan-vien";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("nhanVien",new NhanVien());
        return "create-nv";
    }

    @PostMapping("/add")
    public String store(@ModelAttribute NhanVien nhanVien, @RequestParam String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = null;
        System.out.println(date);
        try {
             ngaySinh = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nhanVien.setNgaySinh(ngaySinh);
        nhanVien.setId(id++);
        this.nhanVienList.add(nhanVien);
        return "redirect:/nhan-vien";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        for(NhanVien nhanVien : this.nhanVienList){
            if(nhanVien.getId() == Long.valueOf(id)){
                this.nhanVienList.remove(nhanVien);
                break;
            }
        }
        return "redirect:/nhan-vien";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id,@ModelAttribute("nhanVien") NhanVien nv,@RequestParam String date) {
        for(NhanVien nhanVien : this.nhanVienList){
            if(nhanVien.getId() == Long.valueOf(id)){
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date ngaySinh = null;
                System.out.println(date);
                try {
                    ngaySinh = dateFormat.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                nv.setNgaySinh(ngaySinh);
                this.nhanVienList.set(this.nhanVienList.indexOf(nhanVien),nv);
                break;
            }
        }
        return "redirect:/nhan-vien";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id") String id){
        for(NhanVien x : this.nhanVienList){
            if(x.getId() == Long.valueOf(id)){
                model.addAttribute("nhanVien",x);
                Date date = x.getNgaySinh();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = sdf.format(date);
                model.addAttribute("date2",formattedDate);
                break;
            }
        }
        return "edit-nv";
    }

}
