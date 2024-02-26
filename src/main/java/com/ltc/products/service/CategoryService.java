package com.ltc.products.service;

import com.ltc.products.dto.CategoryDTO;
import com.ltc.products.models.Category;
import com.ltc.products.models.Product;
import com.ltc.products.repository.CategoryRep;
import com.ltc.products.repository.ProductRep;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRep categoryRep;
    private final ModelMapper modelMapper;
    private final ProductRep productRep;

    public List<Category> getAll() {
        return categoryRep.findAll();
    }

    public Category findById(Long id){
        return categoryRep.findById(id).orElseThrow();
    }

    public void addCategory (CategoryDTO newCat){
        Category category = modelMapper.map(newCat, Category.class);
        categoryRep.save(category);
    }

    public void delete(Long id){
        Category category = categoryRep.findById(id).orElseThrow();
        categoryRep.delete(category);
    }

    public void update (Long id, CategoryDTO catDTO){
        Category category = categoryRep.findById(id).orElseThrow();
        modelMapper.map(catDTO, category);
        categoryRep.save(category);
    }

    public List<Product> getAllProductsInCategoryByName(String categoryName) {
        return categoryRep.findAllProductsInCategoryByName(categoryName);
    }

    public BigDecimal getTotalPriceForCategory(String categoryName) {
        return categoryRep.getTotalPriceForCategory(categoryName);
    }

    public Category getCategoryWithMostExpensiveProduct() {
        return categoryRep.findCategoryWithMostExpensiveProduct();
    }


}
