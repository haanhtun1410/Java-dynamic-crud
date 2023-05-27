package com.example.demo_springboot.controller;

import com.example.demo_springboot.domain.FormField;
import com.example.demo_springboot.domain.KhachHang;
import com.example.demo_springboot.domain.NhanVienTEST;
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
    private ArrayList<NhanVienTEST> nhanVienTESTList = new ArrayList<>();
    private ArrayList<KhachHang> khachHangList = new ArrayList<KhachHang>();

    {
            NhanVienTEST nhanVienTEST1 = new NhanVienTEST(1L,"NV001", "John Doe", "Male", new Date(), "123 Main St", "1234567890", "password1", 1);
            NhanVienTEST nhanVienTEST2 = new NhanVienTEST(2L,"NV002", "Jane Smith", "Female", new Date(), "456 Elm St", "0987654321", "password2", 1);
            NhanVienTEST nhanVienTEST3 = new NhanVienTEST(3L,"NV003", "Robert Johnson", "Male", new Date(), "789 Oak St", "9876543210", "password3", 1);
            NhanVienTEST nhanVienTEST4 = new NhanVienTEST(4L,"NV004", "Emily Davis", "Female", new Date(), "321 Pine St", "0123456789", "password4", 1);
            NhanVienTEST nhanVienTEST5 = new NhanVienTEST(5L,"NV005", "Michael Brown", "Male", new Date(), "654 Cedar St", "5678901234", "password5", 1);
            nhanVienTESTList.add(nhanVienTEST1);
            nhanVienTESTList.add(nhanVienTEST2);
            nhanVienTESTList.add(nhanVienTEST3);
            nhanVienTESTList.add(nhanVienTEST4);
            nhanVienTESTList.add(nhanVienTEST5);
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
        else listClass = nhanVienTESTList;
        md.addAttribute("classList",listClass);
        return "hompage";
    }


}
