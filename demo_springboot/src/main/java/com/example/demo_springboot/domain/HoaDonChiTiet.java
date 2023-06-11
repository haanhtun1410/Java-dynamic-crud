package com.example.demo_springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HoaDonChiTiet {
    @EmbeddedId
    private HoaDonChiTietId id;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia", precision = 20)
    private BigDecimal donGia;

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

    public HoaDonChiTietId getId() {
        return id;
    }

    public HoaDonChiTiet(HoaDonChiTietId id) {
        this.id = id;
    }

    public void setId(HoaDonChiTietId id) {
        this.id = id;
    }
}