package com.ltc.products.dto;

import com.ltc.products.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String name;
    private Integer count;
    private String origin;
    private String manufacturingDate;
    private Integer price;
    private Category category;
}
