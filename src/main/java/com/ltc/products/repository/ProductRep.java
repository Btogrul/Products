package com.ltc.products.repository;

import com.ltc.products.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRep extends JpaRepository<Product, Long> {
    ArrayList<Product> findAll();
}
