package com.example.demo_springboot.services;

import com.example.demo_springboot.domain.NhanVien;
import com.example.demo_springboot.repos.NhanVienRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("NhanVien")
public class NhanVienService implements TemplateService<NhanVien, UUID> {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien findById(UUID uuid) {
        return nhanVienRepository.findById(uuid).orElse(null);
    }

    @Override
    public NhanVien save(NhanVien entity) {
        return nhanVienRepository.save(entity);
    }

    @Override
    public void delete(UUID uuid) {
        nhanVienRepository.deleteById(uuid);
    }
}
