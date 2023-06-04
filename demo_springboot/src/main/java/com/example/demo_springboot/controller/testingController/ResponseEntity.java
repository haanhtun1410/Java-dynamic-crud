package com.example.demo_springboot.controller.testingController;

import java.util.List;

public interface ResponseEntity<T,ID> {
    T create(T entity) ;
    T update(T entity);
    List<T> getAll();
    T getById(ID id);
    void delete(ID id);
}
