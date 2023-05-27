package com.example.demo_springboot.services;
import com.example.demo_springboot.domain.DongSp;
import com.example.demo_springboot.repos.DongSpRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSpService implements TemplateService<DongSp, UUID> {

    @Autowired
    private DongSpRepository dongSpRepository;

    @Override
    public List<DongSp> findAll() {
        return dongSpRepository.findAll();
    }

    @Override
    public DongSp findById(UUID id) {
        return dongSpRepository.findById(id).orElse(null);
    }

    @Override
    public DongSp save(DongSp entity) {
        return dongSpRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        dongSpRepository.deleteById(id);
    }
}
