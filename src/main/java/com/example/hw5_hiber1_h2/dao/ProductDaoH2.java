package com.example.hw5_hiber1_h2.dao;

import com.example.hw5_hiber1_h2.model.Product;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductDaoH2 implements ProductDao {

    private final SessionFactoryBean sessionFactoryBean;
    private SessionFactory factory;

    @PostConstruct
    public void init() {
        factory = sessionFactoryBean.getFactory();
        try (Session session = factory.getCurrentSession()) {
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            transaction.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Session session = factory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            products = session.createQuery("select p from Product p").getResultList();
            transaction.commit();
        }
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product;
        try (Session session = factory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            product = session.get(Product.class, id);
            transaction.commit();
        }
        return Optional.of(product);
    }

    @Override
    public Product saveOrUpdate(Product p) {
        try (Session session = factory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(p);
            transaction.commit();
        }
        return p;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete Product where id = :param").setParameter("param", id).executeUpdate();
            transaction.commit();
        }
    }
}
