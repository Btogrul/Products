package com.ltc.products.service;

import com.ltc.products.dto.CategoryDTO;
import com.ltc.products.dto.ProductDTO;
import com.ltc.products.models.Category;
import com.ltc.products.models.Product;
import com.ltc.products.repository.ProductRep;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRep productRep;
    private final ModelMapper modelMapper;

    public List<Product> getAll() {
        return productRep.findAll();
    }

    public Product findById(Long id){
        return productRep.findById(id).orElseThrow();
    }

    public void addProduct (ProductDTO newProduct){
        Product product = modelMapper.map(newProduct, Product.class);
        productRep.save(product);
    }

    public void delete(Long id){
        Product product = productRep.findById(id).orElseThrow();
        productRep.delete(product);
    }

    public void update (Long id, ProductDTO productDTO){
        Product product = productRep.findById(id).orElseThrow();
        modelMapper.map(productDTO, product);
        productRep.save(product);
    }
}
