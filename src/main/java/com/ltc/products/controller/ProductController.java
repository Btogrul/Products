package com.ltc.products.controller;

import com.ltc.products.dto.ProductRequestDto;
import com.ltc.products.dto.ProductResponseDto;
import com.ltc.products.models.Product;
import com.ltc.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @GetMapping("/all")
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("{id}")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequestDto newProduct) {
        productService.addProduct(newProduct);
        return ResponseEntity.ok("Product added successfully");
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto updatedProduct) {
        productService.update(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
