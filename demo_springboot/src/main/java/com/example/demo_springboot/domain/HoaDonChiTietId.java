package com.example.demo_springboot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class HoaDonChiTietId implements Serializable {
    private static final long serialVersionUID = 6997533487734193841L;
    @Column(name = "IdHoaDon", nullable = false)
    private UUID idHoaDon;
    @Column(name = "IdChiTietSP", nullable = false)
    private UUID idChiTietSP;

    public UUID getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(UUID idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public UUID getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(UUID idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHoaDon, idChiTietSP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HoaDonChiTietId entity = (HoaDonChiTietId) o;
        return Objects.equals(this.idHoaDon, entity.idHoaDon) &&
                Objects.equals(this.idChiTietSP, entity.idChiTietSP);
    }
}