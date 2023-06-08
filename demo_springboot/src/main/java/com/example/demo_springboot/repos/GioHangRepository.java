package com.example.demo_springboot.repos;

import com.example.demo_springboot.domain.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
}