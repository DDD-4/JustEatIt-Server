package com.ddd.justeatit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RestaurantDto {
    private String restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantType;
    private String restaurantWeight;
    private Integer restaurantPrice;

//    public RestaurantDto(String restaurantId, String restaurantName, String restaurantAddress, String restaurantType, String restaurantWeight, Integer restaurantPrice) {
//        this.restaurantId = restaurantId;
//        this.restaurantName = restaurantName;
//        this.restaurantAddress = restaurantAddress;
//        this.restaurantType = restaurantType;
//        this.restaurantWeight = restaurantWeight;
//        this.restaurantPrice = restaurantPrice;
//    }
}
