package com.example.demo_springboot.services;

import com.example.demo_springboot.domain.MauSac;
import com.example.demo_springboot.repos.MauSacRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("MauSac")
public class MauSacService implements TemplateService<MauSac, UUID> {

    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> findAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSac findById(UUID uuid) {
        return mauSacRepository.findById(uuid).orElse(null);
    }

    @Override
    public MauSac save(MauSac entity) {
        return mauSacRepository.save(entity);
    }

    @Override
    public void delete(UUID uuid) {
        mauSacRepository.deleteById(uuid);
    }
}
