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
    private UUID id;

    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Override
    public String toString() {
        return ten;
    }
}