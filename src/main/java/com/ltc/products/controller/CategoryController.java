package com.ltc.products.controller;

import com.ltc.products.dto.*;
import com.ltc.products.models.Category;
import com.ltc.products.models.Product;
import com.ltc.products.service.CategoryService;
import com.ltc.products.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final EmailService email;
    @GetMapping("cars-obj")
    public ArrayList<CopartCarDTO> getCopartCarsAll(){
        return categoryService.getCarsAll();
    }
    @GetMapping("hello")
    public String categoryHello(){
       return categoryService.getLaunches();
    }

    @GetMapping("obj")
    public ArrayList<LaunchDTO> getLaunch(){
        return categoryService.getLaunchesObj();
    }



    @GetMapping("/all")
    public List<CategoryResponseDTO> getAllCategories() {
        email.sendEmail();
        return categoryService.getAll();
    }

    @GetMapping("/id")
    public ResponseEntity<Category> getCategoryById(@RequestParam Long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<String> addCategory(@RequestBody CategoryRequestDto newCategory) {
        categoryService.addCategory(newCategory);
        return ResponseEntity.ok("Category added successfully");
    }

    @PutMapping
    public void updateCategory(@RequestParam Long id, @RequestBody CategoryResponseDTO updatedCategory) {
        categoryService.update(id, updatedCategory);
    }

    @DeleteMapping
    public void deleteCategory(@RequestParam Long id) {
        categoryService.delete(id);
    }

    @GetMapping("/products/{categoryName}")
    public List<Product> getAllProductsInCategory(@PathVariable String categoryName) {
        return categoryService.getAllProductsInCategoryByName(categoryName);
    }

    @GetMapping("/total-price/{categoryName}")
    public BigDecimal getTotalPriceForCategory(@PathVariable String categoryName) {
        return categoryService.getTotalPriceForCategory(categoryName);
    }

    @GetMapping("/most-expensive-category")
    public Category getCategoryWithMostExpensiveProduct() {
        return categoryService.getCategoryWithMostExpensiveProduct();
    }
}
