package com.ltc.products.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String name;
    private Integer count;
    private String origin;
    private String manufacturingDate;
    private Integer price;
    private Long categoryId;


}
