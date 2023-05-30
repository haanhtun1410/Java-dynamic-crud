
package com.example.demo_springboot.domain;


import lombok.*;
import java.util.UUID;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.Set;

@Entity
@Table(name = "DongSP",
        schema = "dbo",
        catalog = "FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041",
        uniqueConstraints = @UniqueConstraint(columnNames = "Ma")
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DongSp implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @FormField(label = "ID", type = FormField.FieldType.TEXT)
    private String id;

    @FormField(label = "Mã sản phẩm", type = FormField.FieldType.TEXT)
    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @FormField(label = "Tên sản phẩm", type = FormField.FieldType.TEXT)
    @Column(name = "Ten")
    private String ten;

    @Override
    public String toString() {
        return ten;
    }
}



