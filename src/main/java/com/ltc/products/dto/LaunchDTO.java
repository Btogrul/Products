package com.ltc.products.dto;

import lombok.Data;

@Data
public class LaunchDTO {
    public String core_serial;
    public int flight;
    public int block;
    public boolean gridfins;
    public boolean legs;
    public boolean reused;
    public boolean land_success;
    public boolean landing_intent;
    public String landing_type;
    public String landing_vehicle;
}
