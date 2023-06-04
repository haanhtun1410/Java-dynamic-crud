package com.example.demo_springboot.controller.testingController;

import com.example.demo_springboot.domain.NhanVienTEST;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVIenController {

    private ArrayList<NhanVienTEST> nhanVienTESTList = new ArrayList<>();
    static Long id = 6L;

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
        System.out.println(nhanVienTEST1.getNgaySinh());
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("nhanVienList",this.nhanVienTESTList);
        return "nhan-vien";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("nhanVien",new NhanVienTEST());
        return "create-nv";
    }

    @PostMapping("/add")
    public String store(@ModelAttribute NhanVienTEST nhanVienTEST, @RequestParam String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = null;
        System.out.println(date);
        try {
             ngaySinh = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nhanVienTEST.setNgaySinh(ngaySinh);
        nhanVienTEST.setId(id++);
        this.nhanVienTESTList.add(nhanVienTEST);
        return "redirect:/nhan-vien";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        for(NhanVienTEST nhanVienTEST : this.nhanVienTESTList){
            if(nhanVienTEST.getId() == Long.valueOf(id)){
                this.nhanVienTESTList.remove(nhanVienTEST);
                break;
            }
        }
        return "redirect:/nhan-vien";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @ModelAttribute("nhanVien") NhanVienTEST nv, @RequestParam String date) {
        for(NhanVienTEST nhanVienTEST : this.nhanVienTESTList){
            if(nhanVienTEST.getId() == Long.valueOf(id)){
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date ngaySinh = null;
                System.out.println(date);
                try {
                    ngaySinh = dateFormat.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                nv.setNgaySinh(ngaySinh);
                this.nhanVienTESTList.set(this.nhanVienTESTList.indexOf(nhanVienTEST),nv);
                break;
            }
        }
        return "redirect:/nhan-vien";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id") String id){
        for(NhanVienTEST x : this.nhanVienTESTList){
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
