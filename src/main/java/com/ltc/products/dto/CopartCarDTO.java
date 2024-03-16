package com.ltc.products.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class CopartCarDTO {
    public String lot_id;
    public String site;
    public String item_id;
    public String salvage_id;
    public int odometer;
    public int price_new;
    public int price_future;
    public int price_old;
    public int cost_priced;
    public int cost_repair;
    public String year;
    public Date auction_date;
    public boolean auction_date_known;
    public String auction_status;
    public String cylinders;
    public String state;
    public String vehicle_type;
    public String auction_type;
    public String make;
    public String model;
    public String series;
    public String loss;
    public String damage_pr;
    public String damage_sec;
    public String status;
    public String keys;
    public String odobrand;
    public String fuel;
    public String drive;
    public String transmission;
    public String color;
    public String title;
    public String vin;
    public String engine;
    public ArrayList<String> link_img_hd;
    public String image_360;
    public String location;
    public String document;
    public String seller;
}
