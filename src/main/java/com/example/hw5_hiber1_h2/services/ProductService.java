package com.example.hw5_hiber1_h2.services;

import com.example.hw5_hiber1_h2.dao.ProductDao;
import com.example.hw5_hiber1_h2.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product saveOrUpdate(Product p) {
        return productRepository.saveOrUpdate(p);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
