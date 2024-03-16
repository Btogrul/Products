package com.ltc.products.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CopartDTO {
    public int size;
    public int page;
    public ArrayList<CopartCarDTO> data;
}
