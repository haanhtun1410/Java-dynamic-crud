package com.example.demo_springboot.model;

import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class CuaHang implements java.io.Serializable {

    private Long id;
    @NotBlank
    private String ma;
    @NotBlank
    private String ten;
    @NotBlank
    private String diaChi;
    @NotBlank
    private String thanhPho;
    @NotBlank
    private String quocGia;



    public CuaHang() {
    }

    public CuaHang(Long id) {
        this.id = id;
    }

    public CuaHang(Long id, String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMa() {
        return this.ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return this.thanhPho;
    }
    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuocGia() {
        return this.quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }


    @Override
    public String toString() {
        return ten;
    }
}