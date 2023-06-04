package com.example.demo_springboot.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class SanPham implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", unique = true, nullable = false, length = 36,columnDefinition = "VARCHAR(36)" )
    @FormField(label = "ID", type = FormField.FieldType.ID)
    private UUID id;

    @Column(name = "Ma", unique = true, length = 20)
    @FormField(label = "Mã Sản Phẩm", type = FormField.FieldType.TEXT)
    private String ma;

    @Column(name = "Ten")
    @FormField(label = "Tên Sản Phẩm", type = FormField.FieldType.TEXT)
    private String ten;

    public SanPham(String id) {
        this.id = UUID.fromString(id);
    }
    @Override
    public String toString() {
        return ten;
    }
}