package com.example.demo_springboot.services;

import com.example.demo_springboot.domain.SanPham;
import com.example.demo_springboot.repos.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("SanPham")
public class SanPhamService implements TemplateService<SanPham, UUID> {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> findAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham findById(UUID uuid) {
        return sanPhamRepository.findById(uuid).orElse(null);
    }

    @Override
    public SanPham save(SanPham entity) {
        return sanPhamRepository.save(entity);
    }

    @Override
    public void delete(UUID uuid) {
        sanPhamRepository.deleteById(uuid);
    }
}
