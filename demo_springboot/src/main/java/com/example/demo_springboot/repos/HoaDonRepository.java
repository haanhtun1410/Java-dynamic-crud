package com.example.demo_springboot.repos;

import com.example.demo_springboot.domain.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
}