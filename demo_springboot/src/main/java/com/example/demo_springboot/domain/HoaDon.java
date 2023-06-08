package com.example.demo_springboot.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "HoaDon", indexes = {
        @Index(name = "UQ__HoaDon__3214CC9E5852BE1D", columnList = "Ma", unique = true)
})
@Entity
public class HoaDon {
    @Id
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang idKH;

    @ManyToOne
    @JoinColumn(name = "IdNV")
    private NhanVien idNV;

    @Column(name = "Ma", length = 20)
    private String ma;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgayThanhToan")
    private LocalDate ngayThanhToan;

    @Column(name = "NgayShip")
    private LocalDate ngayShip;

    @Column(name = "NgayNhan")
    private LocalDate ngayNhan;

    @Column(name = "TinhTrang")
    private Integer tinhTrang;

    @Column(name = "TenNguoiNhan", length = 50)
    private String tenNguoiNhan;

    @Column(name = "DiaChi", length = 100)
    private String diaChi;

    @Column(name = "Sdt", length = 30)
    private String sdt;

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public LocalDate getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(LocalDate ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public LocalDate getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(LocalDate ngayShip) {
        this.ngayShip = ngayShip;
    }

    public LocalDate getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(LocalDate ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public NhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien idNV) {
        this.idNV = idNV;
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
}