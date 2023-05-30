
package com.example.demo_springboot.domain;


import lombok.*;
import java.util.UUID;
import jakarta.persistence.*;
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



