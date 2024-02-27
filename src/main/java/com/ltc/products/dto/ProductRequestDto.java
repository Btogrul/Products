package com.ltc.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String name;
    private Integer count;
    private String origin;
    private String manufacturingDate;
    private Integer price;
    private Long categoryId;
}
