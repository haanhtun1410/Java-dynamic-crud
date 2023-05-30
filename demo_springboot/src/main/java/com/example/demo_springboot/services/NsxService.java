package com.example.demo_springboot.services;

import com.example.demo_springboot.domain.Nsx;
import com.example.demo_springboot.repos.NsxRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("Nsx")
public class NsxService implements TemplateService<Nsx, UUID> {

    @Autowired
    private NsxRepository nsxRepository;

    @Override
    public List<Nsx> findAll() {
        return nsxRepository.findAll();
    }

    @Override
    public Nsx findById(UUID uuid) {
        return nsxRepository.findById(uuid).orElse(null);
    }

    @Override
    public Nsx save(Nsx entity) {
        return nsxRepository.save(entity);
    }

    @Override
    public void delete(UUID uuid) {
        nsxRepository.deleteById(uuid);
    }
}
