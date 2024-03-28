package com.ltc.products.service;

import com.ltc.products.dto.ProductRequestDto;
import com.ltc.products.dto.ProductResponseDto;
import com.ltc.products.models.Product;
import com.ltc.products.repository.CategoryRep;
import com.ltc.products.repository.ProductRep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRep productRep;

    @Mock
    private CategoryRep categoryRep;

    @Mock //repository ve maplarda istifade olur (yeni yalanci bir data verilen test uchun)
    private ModelMapper modelMapper;

    @InjectMocks // hansi classi dogrudanda test elemek isteyirikse birbasha onu yaziriq
    private ProductService productService;

    @Test
    public void getAllTest() {
        Product productEntity = new Product(3L, "Hey", 2, "there", "test", 3);
        Product productEntity2 = Product.builder()
                .Id(31L)
                .name("X")
                .count(23)
                .origin("zzz")
                .manufacturingDate("2321")
                .price(231)
                .build();

        List<Product> productEntities = Arrays.asList(productEntity, productEntity2);

        List<ProductResponseDto> expectedData = productEntities.stream()
                .map(this::mapToProductResponseDto)
                .collect(Collectors.toList());

        when(productService.getAll()).thenReturn(expectedData);

        List<ProductResponseDto> actualData = productService.getAll();
        Assertions.assertEquals(expectedData, actualData);

    }

    private ProductResponseDto mapToProductResponseDto(Product product) {
        return modelMapper.map(product, ProductResponseDto.class);

    }


    public Product convertToDao(ProductResponseDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

    @Test
    public void findByIdTest() {
        Product productEntity = new Product(3L, "Hey", 2, "there", "test", 3);
        when(productRep.findById(2L)).thenReturn(Optional.of(productEntity));

        Product byId = productService.findById(2L);


        Assertions.assertEquals(byId, productEntity);

    }

    @Test
    void addProductTest(){

        ProductRequestDto dto = new ProductRequestDto( "Hey", 2 , "test", "USA",15, 1L);

        Product newProduct = new Product();

        when(modelMapper.map(dto, Product.class)).thenReturn(newProduct);

        String actual = productService.addProduct(dto);

        Assertions.assertEquals("Successful", actual);


    }

//    @Test
//    void delete(){
//        Product productEntity = new Product(3L, "Hey", 2, "there", "test", 3);
//        when(productRep.delete(productEntity)).thenReturn());
//    }

}
