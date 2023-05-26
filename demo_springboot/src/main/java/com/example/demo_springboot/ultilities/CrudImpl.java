package com.example.demo_springboot.ultilities;

import java.util.List;

public class CrudImpl implements Crud {
    public <T> CrudImpl(Class<T> clazz) {
    }

    @Override
    public <T> List<T> readAll() {
        return null;
    }
}
