
package com.example.demo_springboot.model;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

/**
 * DongSp generated by hbm2java
 */
@Entity
@Table(name="DongSP"
        ,schema="dbo"
        ,catalog="FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041"
        , uniqueConstraints = @UniqueConstraint(columnNames="Ma")
)
public class DongSp  implements java.io.Serializable {

    private UUID id;
    private String ma;
    private String ten;
    private Set<ChiTietSp> chiTietSps = new HashSet<ChiTietSp>(0);

    public DongSp() {
    }


    public DongSp(UUID id) {
        this.id = id;
    }
    public DongSp(UUID id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;

    }

    @Id
    @Column(name="Id", unique=true, nullable=false, length=36)
    public UUID getId() {
        return this.id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    @Column(name="Ma", unique=true, length=20)
    public String getMa() {
        return this.ma;
    }
    public void setMa(String ma) {
        this.ma = ma;
    }
    @Column(name="Ten")
    public String getTen() {
        return this.ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }


    @OneToMany(fetch=FetchType.EAGER, mappedBy="dongSp", cascade = CascadeType.ALL)
    public Set<ChiTietSp> getChiTietSps() {
        return this.chiTietSps;
    }

    public void setChiTietSps(Set<ChiTietSp> chiTietSps) {
        this.chiTietSps = chiTietSps;
    }

    @Override
    public String toString() {
        return ten;
    }



}

