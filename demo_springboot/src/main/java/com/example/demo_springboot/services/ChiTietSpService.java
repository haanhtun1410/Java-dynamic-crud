package com.example.demo_springboot.services;

import com.example.demo_springboot.domain.ChiTietSp;
import com.example.demo_springboot.repos.ChiTietSpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service("ChiTietSp")
public class ChiTietSpService implements TemplateService<ChiTietSp,UUID> {

    @Autowired
    private ChiTietSpRepository chiTietSpRepository;

    @Override
    @Transactional
    public List<ChiTietSp> findAll() {
        return chiTietSpRepository.findAll();
    }

    @Override
    public ChiTietSp findById(UUID uuid) {
        return chiTietSpRepository.findById(uuid).get();
    }

    @Override
    public ChiTietSp save(ChiTietSp entity) {
         return chiTietSpRepository.save(entity);
    }

    @Override
    public void delete(UUID uuid) {
        chiTietSpRepository.deleteById(uuid);
    }

    public List<ChiTietSp> findAllByDongSpId(UUID idDsp){
             return chiTietSpRepository.findAllByDongSpId(idDsp);
    }

}
