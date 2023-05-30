package com.example.demo_springboot.domain;

import lombok.*;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "KhachHang")
public class KhachHang {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Temporal(TemporalType.DATE)
    @Column(name = "NgaySinh", length = 10)
    private Date ngaySinh;

    @Column(name = "Sdt", length = 30)
    private String sdt;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    @Column(name = "MatKhau")
    private String matKhau;

    @Override
    public String toString() {
        return ten;
    }

}
