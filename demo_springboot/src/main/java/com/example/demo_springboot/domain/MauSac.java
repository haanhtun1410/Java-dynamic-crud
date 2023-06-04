
package com.example.demo_springboot.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import jakarta.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "MauSac",
        schema = "dbo",
        catalog = "FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041",
        uniqueConstraints = @UniqueConstraint(columnNames = "Ma")
)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class MauSac implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @FormField(label = "ID", type = FormField.FieldType.ID)
    private UUID id;

    @Column(name = "Ma", unique = true, length = 20)
    @FormField(label = "Mã Màu", type = FormField.FieldType.TEXT)
    private String ma;

    @Column(name = "Ten")
    @FormField(label = "Tên Màu", type = FormField.FieldType.TEXT)
    private String ten;

    public MauSac(String id) {
        this.id = UUID.fromString(id);
    }

    @Override
    public String toString() {
        return ten;
    }
}
