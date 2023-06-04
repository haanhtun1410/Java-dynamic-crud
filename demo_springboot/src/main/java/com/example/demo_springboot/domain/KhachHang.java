package com.example.demo_springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "KhachHang")
@JsonIgnoreProperties(ignoreUnknown = true)
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @FormField(label = "ID", type = FormField.FieldType.ID)
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    @FormField(label = "Mã", type = FormField.FieldType.TEXT)
    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @FormField(label = "Tên", type = FormField.FieldType.TEXT)
    @Column(name = "Ten")
    private String ten;

    @FormField(label = "Tên đệm", type = FormField.FieldType.TEXT)
    @Column(name = "TenDem")
    private String tenDem;

    @FormField(label = "Họ", type = FormField.FieldType.TEXT)
    @Column(name = "Ho")
    private String ho;

    @FormField(label = "Ngày sinh", type = FormField.FieldType.DATE)
    @Temporal(TemporalType.DATE)
    @Column(name = "NgaySinh", length = 10)
    private Date ngaySinh;

    @FormField(label = "Số điện thoại", type = FormField.FieldType.TEXT)
    @Column(name = "Sdt", length = 30)
    private String sdt;

    @FormField(label = "Địa chỉ", type = FormField.FieldType.TEXT)
    @Column(name = "DiaChi")
    private String diaChi;

    @FormField(label = "Thành phố", type = FormField.FieldType.TEXT)
    @Column(name = "ThanhPho")
    private String thanhPho;

    @FormField(label = "Quốc gia", type = FormField.FieldType.TEXT)
    @Column(name = "QuocGia")
    private String quocGia;

    @FormField(label = "Mật khẩu", type = FormField.FieldType.TEXT)
    @Column(name = "MatKhau")
    private String matKhau;

    @Override
    public String toString() {
        return ten;
    }
}
