package com.ltc.products.config.feign;

import com.ltc.products.dto.CopartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@FeignClient(name = "copartApiClient", url = "https://api.apicar.store/public/docs/current_lots.json")

public interface CopartApiClient {
    @GetMapping
    CopartDTO getCars();
}
