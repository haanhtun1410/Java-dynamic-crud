package com.example.demo_springboot.repos;

import com.example.demo_springboot.domain.HoaDonChiTiet;
import com.example.demo_springboot.domain.HoaDonChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, HoaDonChiTietId> {

}