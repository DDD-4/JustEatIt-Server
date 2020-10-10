package com.ddd.justeatit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserPreferInfoDto {
    private List<String> foodWeight;
    private List<String> foodCategory;
    private Integer foodPriceMin;
    private Integer foodPriceMax;

    public UserPreferInfoDto(String json) {
    }
}
