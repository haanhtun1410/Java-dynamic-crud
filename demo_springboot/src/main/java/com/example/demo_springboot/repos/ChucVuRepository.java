package com.example.demo_springboot.repos;

import com.example.demo_springboot.domain.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
}