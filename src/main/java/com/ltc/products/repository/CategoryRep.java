package com.ltc.products.repository;

import com.ltc.products.models.Category;
import com.ltc.products.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface CategoryRep  extends JpaRepository<Category, Long> {
    ArrayList<Category> findAll();

    List<Category> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.category.name = :categoryName")
    List<Product> findAllProductsInCategoryByName(@Param("categoryName") String categoryName);

    @Query("SELECT SUM(p.price) FROM Product p WHERE p.category.name = :categoryName")
    BigDecimal getTotalPriceForCategory(@Param("categoryName") String categoryName);

    @Query("SELECT c FROM Category c WHERE c.id = (SELECT p.category.id FROM Product p ORDER BY p.price DESC LIMIT 1)")
    Category findCategoryWithMostExpensiveProduct();
}
