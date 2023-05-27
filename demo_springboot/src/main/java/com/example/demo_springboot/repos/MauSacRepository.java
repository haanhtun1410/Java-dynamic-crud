package com.example.demo_springboot.repos;

import com.example.demo_springboot.domain.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
}