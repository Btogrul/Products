package com.ltc.products.service;

import com.ltc.products.dto.CategoryRequestDto;
import com.ltc.products.dto.CategoryResponseDTO;
import com.ltc.products.models.Category;
import com.ltc.products.models.Product;
import com.ltc.products.repository.CategoryRep;
import com.ltc.products.repository.ProductRep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRep categoryRep;
    private final ModelMapper modelMapper;
    private final ProductRep productRep;

    public List<CategoryResponseDTO> getAll() {
        ArrayList<Category> all = categoryRep.findAll();
        List<CategoryResponseDTO> responseList = all.stream()
                .map(this::mapToProductResponseDto) // Assuming you have a method to map Product to ProductResponseDto
                .collect(Collectors.toList());

        return responseList;
    }

    private CategoryResponseDTO mapToProductResponseDto(Category category) {
        return modelMapper.map(category, CategoryResponseDTO.class);
    }

    public Category findById(Long id) {
        return categoryRep.findById(id).orElseThrow();
    }

    public void addCategory(CategoryRequestDto newCat) {
        Category category = modelMapper.map(newCat, Category.class);
        categoryRep.save(category);
    }

    public void delete(Long id) {
        Category category = categoryRep.findById(id).orElseThrow();
        categoryRep.delete(category);
    }

    public void update(Long id, CategoryResponseDTO catDTO) {
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
