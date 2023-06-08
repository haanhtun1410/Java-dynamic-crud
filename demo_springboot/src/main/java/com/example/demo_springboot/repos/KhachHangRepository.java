package com.example.demo_springboot.repos;

import com.example.demo_springboot.domain.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    KhachHang findByMaAndMatKhau(String ma,String matKhau);
}