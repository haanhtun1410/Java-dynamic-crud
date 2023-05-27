package com.example.demo_springboot.services;
import com.example.demo_springboot.domain.ChucVu;
import com.example.demo_springboot.repos.ChucVuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuService implements TemplateService<ChucVu, UUID> {

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> findAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public ChucVu findById(UUID uuid) {
        return chucVuRepository.findById(uuid).orElse(null);
    }

    @Override
    public ChucVu save(ChucVu entity) {
        return chucVuRepository.save(entity);
    }

    @Override
    public void delete(UUID uuid) {
        chucVuRepository.deleteById(uuid);
    }
}
