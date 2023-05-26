package com.example.demo_springboot.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {


    private long id;
    @FormField(type = FormField.FieldType.TEXT,label = "Ma nhan vien")
    @NotBlank(message = "Không được để trống")
    private String ma;
    @FormField(type = FormField.FieldType.TEXT,label = "ten nhan vien")
    @NotBlank(message = "Không được để trống")
    private String ten;
    @FormField(type = FormField.FieldType.DATE,label = "ngay sinh nhan vien")
    private Date ngaySinh;
    @NotBlank
    @FormField(type = FormField.FieldType.TEXT,label = "sdt nhan vien")
    private String sdt;
    @NotBlank
    private String diaChi;
    @NotBlank
    private String thanhPho;
    @NotBlank
    private String quocGia;
    @NotBlank
    private String matKhau;



}
