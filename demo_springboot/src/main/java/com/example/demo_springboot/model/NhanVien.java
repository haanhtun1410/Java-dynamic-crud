package com.example.demo_springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    private Long id;
    private String ma;
    private String ten;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private int trangThai;

}
