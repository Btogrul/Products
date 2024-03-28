package com.ltc.products.service;

import com.ltc.products.dto.CategoryResponseDTO;
import com.ltc.products.dto.ProductRequestDto;
import com.ltc.products.dto.ProductResponseDto;
import com.ltc.products.models.Category;
import com.ltc.products.models.Product;
import com.ltc.products.repository.CategoryRep;
import com.ltc.products.repository.ProductRep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRep productRep;
    private final ModelMapper modelMapper;
    private final CategoryRep categoryRep;


    public List<ProductResponseDto> getAll() {
        log.info("get all method starts ");
        List<Product> all = productRep.findAll();

        List<ProductResponseDto> responseList = all.stream()
                .map(this::mapToProductResponseDtoo)
                .collect(Collectors.toList());

        return responseList;


    }

    private ProductResponseDto mapToProductResponseDtoo(Product product) {
     return modelMapper.map(product, ProductResponseDto.class);

    }

    public Product findById(Long id){
        log.info("find byId  method starts ");
        return productRep.findById(id).orElseThrow();

    }

    public String addProduct (ProductRequestDto newProduct){
        //log.info(" add products method starts ");
        Product product = modelMapper.map(newProduct, Product.class);
       // Category category = categoryRep.findById(newProduct.getCategoryId()).orElseThrow();
//        product.setCategory(category);
        productRep.save(product);
        return "Successful";
        //log.info(" add products method end ");
    }

    public void delete(Long id){
        log.info(" product delete start ");
        Product product = productRep.findById(id).orElseThrow();
        productRep.delete(product);
        log.info(" product delete end");
    }

    public void update (Long id, ProductRequestDto productDTO){
        log.info(" update started");
        Product product = productRep.findById(id).orElseThrow();
        modelMapper.map(productDTO, product);
        productRep.save(product);
        log.info(" update finished");
    }
}
