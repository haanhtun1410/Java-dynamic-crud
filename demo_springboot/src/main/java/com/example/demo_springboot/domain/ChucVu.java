package com.example.demo_springboot.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * ChucVu generated by hbm2java
 */
@Data
@Entity
@Table(name="ChucVu"
        ,schema="dbo"
        ,catalog="FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041"
        , uniqueConstraints = @UniqueConstraint(columnNames="Ma")
)
public class ChucVu  implements java.io.Serializable {
    @Id
    @Column(name = "Id", unique = true, length = 36)
    @FormField(label = "id",type = FormField.FieldType.TEXT)
    private UUID id;

    @FormField(label = "Mã",type = FormField.FieldType.TEXT)
    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @FormField(label = "Tên Chức Vụ",type = FormField.FieldType.TEXT)
    @Column(name = "Ten")
    private String ten;
    @Override
    public String toString() {
        return ten;
    }

}