package com.example.demo_springboot.domain;
import lombok.*;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "SanPham",
        schema = "dbo",
        catalog = "FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041",
        uniqueConstraints = @UniqueConstraint(columnNames = "Ma")
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPham implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false, length = 36,columnDefinition = "VARCHAR(36)" )
    @FormField(label = "ID", type = FormField.FieldType.TEXT)
    private UUID id;

    @Column(name = "Ma", unique = true, length = 20)
    @FormField(label = "Mã Màu Sắc", type = FormField.FieldType.TEXT)
    private String ma;

    @Column(name = "Ten")
    @FormField(label = "Tên Màu Sắc", type = FormField.FieldType.TEXT)
    private String ten;

    @Override
    public String toString() {
        return ten;
    }
}