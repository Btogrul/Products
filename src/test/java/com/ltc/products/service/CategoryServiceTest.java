package com.ltc.products.service;

import com.ltc.products.dto.CategoryRequestDto;
import com.ltc.products.dto.CategoryResponseDTO;
import com.ltc.products.dto.ProductRequestDto;
import com.ltc.products.dto.ProductResponseDto;
import com.ltc.products.models.Category;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    private ProductRep productRep;

    @Mock
    private CategoryRep categoryRep;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void getAllCategoryTest(){
        Category newCat = new Category();
        List<Category> catList = List.of(newCat);
        List<CategoryResponseDTO> expectedData = catList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        when(categoryService.getAll()).thenReturn(expectedData);
        List<CategoryResponseDTO> actualData = categoryService.getAll();
        Assertions.assertEquals(expectedData, actualData);
    }
    private CategoryResponseDTO mapToDto(Category category) {
        return modelMapper.map(category, CategoryResponseDTO.class);
    }

    @Test
    void findByIdCatTest(){
        Category newCat = new Category();
        when(categoryRep.findById(1L)).thenReturn(Optional.of(newCat));
        Category byId = categoryService.findById(1L);
        Assertions.assertEquals(byId, newCat);
    }

    @Test
    void addCatTest(){
        CategoryRequestDto newCat = new CategoryRequestDto("X","Xd");


        Category newCategory = new Category();

        when(modelMapper.map(newCat, Category.class)).thenReturn(newCategory);

        String actual = categoryService.addCategory(newCat);

        Assertions.assertEquals("Successful", actual);


    }

    @Test
    void deleteCatTest() {

        Long categoryId = 1L;
        Category categoryEntity = new Category();

        when(categoryRep.findById(categoryId)).thenReturn(Optional.of(categoryEntity));

        categoryService.delete(categoryId);

        verify(categoryRep).delete(categoryEntity);

    }




}
