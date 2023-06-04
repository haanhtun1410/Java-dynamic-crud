package com.example.demo_springboot.domain;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * ChiTietSp generated by hbm2java
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "ChiTietSP" )
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChiTietSp implements java.io.Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @FormField(label = "ID", type = FormField.FieldType.ID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDongSP",  nullable = false)
    @FormField(label = "Dòng sản phẩm", type = FormField.FieldType.SELECT)
    private DongSp dongSp;

    @FormField(label = "Màu sắc", type = FormField.FieldType.SELECT)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNsx")
    @FormField(label = "Nhà sản xuất", type = FormField.FieldType.SELECT)
    private Nsx nsx;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP")
    @FormField(label = "Sản phẩm", type = FormField.FieldType.SELECT)
    private SanPham sanPham;

    @Column(name = "NamBH")
    @FormField(label = "Năm bảo hành", type = FormField.FieldType.NUMBER)
    private Integer namBh;

    @Column(name = "MoTa")
    @FormField(label = "Mô tả", type = FormField.FieldType.TEXT)
    private String moTa;

    @Column(name = "SoLuongTon")
    @FormField(label = "Số lượng tồn", type = FormField.FieldType.NUMBER)
    private Integer soLuongTon;

    @Column(name = "GiaNhap", precision = 20, scale = 0)
    @FormField(label = "Giá nhập", type = FormField.FieldType.NUMBER)
    private BigDecimal giaNhap;

    @Column(name = "GiaBan", precision = 20, scale = 0)
    @FormField(label = "Giá bán", type = FormField.FieldType.NUMBER)
    private BigDecimal giaBan;

    @Override
    public String toString() {
        return "ChiTietSp{" +
                "id=" + id +
                ", dongSp=" + dongSp +
                ", mauSac=" + mauSac +
                ", nsx=" + nsx +
                ", sanPham=" + sanPham +
                '}';
    }
}
