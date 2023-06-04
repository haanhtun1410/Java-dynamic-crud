package com.example.demo_springboot.services;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TemplateService<T,ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T entity);
    void delete(ID id);
}
