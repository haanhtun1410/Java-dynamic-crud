package com.example.demo_springboot.domain;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import jakarta.persistence.*;

import java.util.UUID;

@Data
@Entity
@Table(name = "CuaHang")
public class CuaHang implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @NotBlank
    @Column(name = "Ten")
    private String ten;

    @NotBlank
    @Column(name = "DiaChi")
    private String diaChi;

    @NotBlank
    @Column(name = "ThanhPho")
    private String thanhPho;

    @NotBlank
    @Column(name = "QuocGia")
    private String quocGia;

}