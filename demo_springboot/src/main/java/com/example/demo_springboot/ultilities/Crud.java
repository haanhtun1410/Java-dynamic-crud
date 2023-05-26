package com.example.demo_springboot.ultilities;

import java.util.List;

public interface Crud {
    <T> List<T> readAll();
}
