package com.example.demo_springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GioHangChiTiet {
    @EmbeddedId
    private GioHangChiTietId id;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia", precision = 20)
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam", precision = 20)
    private BigDecimal donGiaKhiGiam;

    public BigDecimal getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(BigDecimal donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public GioHangChiTietId getId() {
        return id;
    }

    public void setId(GioHangChiTietId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GioHangChiTiet{" +
                "id=" + id +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", donGiaKhiGiam=" + donGiaKhiGiam +
                '}';
    }
}