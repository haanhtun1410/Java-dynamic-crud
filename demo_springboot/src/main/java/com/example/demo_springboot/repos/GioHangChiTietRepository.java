package com.example.demo_springboot.repos;

import com.example.demo_springboot.domain.GioHang;
import com.example.demo_springboot.domain.GioHangChiTiet;
import com.example.demo_springboot.domain.GioHangChiTietId;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, GioHangChiTietId> {

    List<GioHangChiTiet> findAllById_IdGioHang(UUID ghid);

    @Modifying
    @Transactional
    @Query("UPDATE GioHangChiTiet e SET e.soLuong = :newValue WHERE e.id = :id")
    void updateValueById(GioHangChiTietId id, int newValue);

    void deleteAllById_IdGioHang(UUID id);

}