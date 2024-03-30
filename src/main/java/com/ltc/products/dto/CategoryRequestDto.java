package com.ltc.products.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestDto {
    private String name;
    private String description;
}
