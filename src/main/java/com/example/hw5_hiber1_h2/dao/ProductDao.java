package com.example.hw5_hiber1_h2.dao;

import com.example.hw5_hiber1_h2.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product saveOrUpdate(Product p);
    void deleteById(Long id);
}
