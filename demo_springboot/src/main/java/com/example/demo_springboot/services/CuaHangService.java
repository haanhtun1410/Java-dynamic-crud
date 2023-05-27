package com.example.demo_springboot.services;
import com.example.demo_springboot.domain.CuaHang;
import com.example.demo_springboot.repos.CuaHangRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CuaHang")
public class CuaHangService implements TemplateService<CuaHang, Long> {

    @Autowired
    private CuaHangRepository cuaHangRepository;


    @Override
    public List<CuaHang> findAll() {
        return cuaHangRepository.findAll();
    }

    @Override
    public CuaHang findById(Long id) {
        Optional<CuaHang> cuaHangOptional = cuaHangRepository.findById(id);
        return cuaHangOptional.orElse(null);
    }

    @Override
    public CuaHang save(CuaHang entity) {
        return cuaHangRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cuaHangRepository.deleteById(id);
    }
}
