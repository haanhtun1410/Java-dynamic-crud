package com.example.demo_springboot.controller;

import com.example.demo_springboot.model.FormField;
import com.example.demo_springboot.model.KhachHang;
import com.example.demo_springboot.model.NhanVien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/test")
public class MainController {
    private ArrayList<NhanVien> nhanVienList = new ArrayList<>();
    private ArrayList<KhachHang> khachHangList = new ArrayList<KhachHang>();

    {
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
            // Creating instance 3 using constructor
            KhachHang khachHang1 = new KhachHang(1, "KH001", "John Doe", new Date(), "1234567890", "123 Main Street", "New York", "USA", "password123");
            khachHangList.add(khachHang1);
            KhachHang khachHang2 = new KhachHang(2, "KH002", "Jane Smith", new Date(), "9876543210", "456 Elm Street", "Los Angeles", "USA", "password456");
            khachHangList.add(khachHang2);
            KhachHang khachHang3 = new KhachHang(3, "KH003", "Alex Johnson", new Date(), "5555555555", "789 Oak Street", "Chicago", "USA", "password789");
            khachHangList.add(khachHang3);

        }
    }

    @GetMapping("/{className}")
    public String index(Model md, @PathVariable String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.example.demo_springboot.model."+className);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FormField.class)) {
                FormField formFieldAnnotation = field.getAnnotation(FormField.class);
                String fieldName = formFieldAnnotation.label();
                String fieldType = formFieldAnnotation.type().getInputType();
                System.out.println("Custom tên nhãn: " + fieldName + ", Input Type: " + fieldType);
            }
        }
        List<?> listClass =new ArrayList<>();
        if(clazz.getName().contains("KhachHang")) listClass = khachHangList;
        else listClass = nhanVienList;
        md.addAttribute("classList",listClass);
        return "hompage";
    }


}
