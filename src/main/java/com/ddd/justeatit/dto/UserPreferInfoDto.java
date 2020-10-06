package com.ddd.justeatit.dto;

import com.ddd.justeatit.Util.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserPreferInfoDto {
    @Autowired
    JsonParser jsonParser;

    private List<String> foodWeight;
    private List<String> foodCategory;
    private Integer foodPriceMin;
    private Integer foodPriceMax;

    public UserPreferInfoDto(String json) {
    }
}
