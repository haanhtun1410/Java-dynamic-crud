package com.example.demo_springboot.repos;

import com.example.demo_springboot.domain.HoaDon;
import com.example.demo_springboot.domain.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    HoaDon findByidKHAndTinhTrang(KhachHang idKH, int tinhTrang);
}