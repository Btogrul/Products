package com.ltc.products.dto;

import com.ltc.products.models.Category;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDTO {
    private String name;
    private Integer count;
    private String origin;
    private String manufacturingDate;
    private Integer price;
    private Category category;

}
