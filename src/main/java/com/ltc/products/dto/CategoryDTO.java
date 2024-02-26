package com.ltc.products.dto;

import com.ltc.products.models.Product;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CategoryDTO {
    private String name;
    private String description;
    private List<Product> products;

}
