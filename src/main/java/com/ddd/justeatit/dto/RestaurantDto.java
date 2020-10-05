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
    private Double restaurantXcord;
    private Double restaurantYcord;
}
