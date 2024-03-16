package com.ltc.products.config.feign;

import com.ltc.products.dto.LaunchDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@FeignClient(name ="rocket-client", url = "https://api.spacexdata.com/v2")
public interface RocketClient {
    @GetMapping("launches")
    String getLaunches();

    @GetMapping("launches")
    ArrayList<LaunchDTO> getObjLaunch();

}
