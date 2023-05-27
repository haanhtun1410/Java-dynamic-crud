package com.example.demo_springboot.services;

import com.example.demo_springboot.domain.ChiTietSp;
import com.example.demo_springboot.repos.ChiTietSpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSpService implements TemplateService<ChiTietSp, UUID> {

    @Autowired
    private ChiTietSpRepository chiTietSpRepository;

    @Override
    public List<ChiTietSp> findAll() {
        return chiTietSpRepository.findAll();
    }

    @Override
    public ChiTietSp findById(UUID uuid) {
        return chiTietSpRepository.findById(uuid).orElse(null);
    }

    @Override
    public ChiTietSp save(ChiTietSp entity) {
         return chiTietSpRepository.save(entity);
    }

    @Override
    public void delete(UUID uuid) {
        chiTietSpRepository.deleteById(uuid);
    }
}
