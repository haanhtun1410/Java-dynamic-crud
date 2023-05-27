package com.example.demo_springboot.repos;

import com.example.demo_springboot.domain.ChiTietSp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ChiTietSpRepository extends JpaRepository<ChiTietSp, UUID> {
}