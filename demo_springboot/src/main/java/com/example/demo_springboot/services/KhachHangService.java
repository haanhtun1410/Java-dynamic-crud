package com.example.demo_springboot.services;

import com.example.demo_springboot.domain.KhachHang;
import com.example.demo_springboot.repos.KhachHangRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("KhachHang")
public class KhachHangService implements TemplateService<KhachHang, UUID> {

    private final KhachHangRepository khachHangRepository;



    @Autowired
    public KhachHangService(KhachHangRepository khachHangRepository) {
        this.khachHangRepository = khachHangRepository;
    }

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang findById(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public KhachHang save(KhachHang entity) {
        return khachHangRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        khachHangRepository.deleteById(id);
    }

    public KhachHang getByUserName(String ma,String mk){
        System.out.println(khachHangRepository.findByMaAndMatKhau(ma,mk));
        return khachHangRepository.findByMaAndMatKhau(ma,mk);
    }
}
