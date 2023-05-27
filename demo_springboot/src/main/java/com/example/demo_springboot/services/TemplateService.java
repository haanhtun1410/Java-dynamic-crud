package com.example.demo_springboot.services;

import java.util.List;

public interface TemplateService<T,ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T entity);
    void delete(ID id);
}
