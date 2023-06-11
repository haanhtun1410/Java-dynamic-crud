package com.example.demo_springboot.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "GioHang", indexes = {
        @Index(name = "UQ__GioHang__3214CC9E6530A26C", columnList = "Ma", unique = true)
})
@Entity
@NoArgsConstructor
public class GioHang {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKH")
    private KhachHang idKH;

    @Column(name = "Ma", length = 20)
    private String ma;

    @Column(name = "TinhTrang")
    private Integer tinhTrang;

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public KhachHang getIdKH() {
        return idKH;
    }

    public void setIdKH(KhachHang idKH) {
        this.idKH = idKH;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public GioHang(KhachHang idKH, String ma, Integer tinhTrang) {
        this.idKH = idKH;
        this.ma = ma;
        this.tinhTrang = tinhTrang;
    }
}