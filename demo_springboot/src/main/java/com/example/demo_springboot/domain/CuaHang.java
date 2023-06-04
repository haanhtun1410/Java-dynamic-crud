package com.example.demo_springboot.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "CuaHang")
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class CuaHang implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @FormField(label = "ID", type = FormField.FieldType.ID)
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    @FormField(label = "Mã cửa hàng",type = FormField.FieldType.TEXT)
    @Column(name = "Ma")
    private String ma;

    @NotBlank
    @FormField(label = "Tên Cửa Hàng",type = FormField.FieldType.TEXT)
    @Column(name = "Ten")
    private String ten;

    @NotBlank
    @Column(name = "DiaChi")
    @FormField(label = "Địa Chỉ",type = FormField.FieldType.TEXT)
    private String diaChi;

    @NotBlank
    @Column(name = "ThanhPho")
    @FormField(label = "Thành Phố",type = FormField.FieldType.TEXT)
    private String thanhPho;

    @NotBlank
    @FormField(label = "QUốc gia",type = FormField.FieldType.TEXT)
    @Column(name = "QuocGia")
    private String quocGia;

    public CuaHang(String id) {
        this.id = UUID.fromString(id);
    }

    @Override
    public String toString() {
        return ten;
    }


}