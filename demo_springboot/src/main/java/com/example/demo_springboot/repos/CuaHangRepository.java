package com.example.demo_springboot.repos;

import com.example.demo_springboot.domain.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, Long> {
}