package com.ddd.justeatit.controller;

import com.ddd.justeatit.dto.RestaurantDto;
import com.ddd.justeatit.dto.UserPreferInfoDto;
import com.ddd.justeatit.service.RestaurantService;
import com.ddd.justeatit.service.UserService;
import com.ddd.justeatit.Util.*;
import com.ddd.justeatit.service.Weight;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/justfind")
public class JustFindController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<RestaurantDto> readRestaurant(@RequestParam(value="users") List<String> users) throws Exception {
        List<UserPreferInfoDto> userPreferInfoDtos = new ArrayList<>();

        HashMap<String, Integer> commonFoodWeight = new HashMap<>();
        HashMap<String, Integer> commonFoodCategory = new HashMap<>();
        Integer commonFoodPriceMin = 0;
        Integer commonFoodPriceMax = Integer.MAX_VALUE;

        for (String userId : users) {
            userPreferInfoDtos.add(userService.readUserPreferInfoByUserId(userId).getBody());
        }

        for (UserPreferInfoDto userPreferInfoDto : userPreferInfoDtos) {
            for (String foodWeight : userPreferInfoDto.getFoodWeight()) {
                if (commonFoodWeight.containsKey(foodWeight)) {
                    commonFoodWeight.put(foodWeight, commonFoodWeight.get(foodWeight) + 1);
                } else {
                    commonFoodWeight.put(foodWeight, 1);
                }
            }

            for (String foodCategory : userPreferInfoDto.getFoodCategory()) {
                if (commonFoodCategory.containsKey(foodCategory)) {
                    commonFoodCategory.put(foodCategory, commonFoodCategory.get(foodCategory) + 1 );
                } else {
                    commonFoodCategory.put(foodCategory, 1);
                }
            }

            commonFoodPriceMin = Math.max(commonFoodPriceMin, userPreferInfoDto.getFoodPriceMin());
            commonFoodPriceMax = Math.min(commonFoodPriceMax, userPreferInfoDto.getFoodPriceMax());
        }

        List<String> resultCommonFoodWeight = new ArrayList<>();
        List<String> resultCommonFoodCategory = new ArrayList<>();

        if (resultCommonFoodWeight.isEmpty()) {
            for (Weight weight : Weight.values()) {
                resultCommonFoodWeight.add(weight.getValue());
            }
        }

        if (resultCommonFoodCategory.isEmpty()) {
            for (Category category : Category.values()) {
                resultCommonFoodCategory.add(category.getValue());
            }
        }

        commonFoodWeight.forEach((k, v) -> {
            if (v == userPreferInfoDtos.size())
                resultCommonFoodWeight.add(k);
        });

        commonFoodCategory.forEach((k, v) -> {
            if (v == userPreferInfoDtos.size())
                resultCommonFoodCategory.add(k);
        });

        return restaurantService.readRestaurantByUserPreferInfo(new UserPreferInfoDto(resultCommonFoodWeight, resultCommonFoodCategory, commonFoodPriceMin, commonFoodPriceMax));
    }
}

@Getter
enum Weight {
    LIGHT("light"),
    MID("mid"),
    HEAVY("heavy");
    private String value;

    Weight(String weight) {
        value = weight;
    }
}

@Getter
enum Category {
    한식("한식"),
    중식("중식"),
    일식("일식"),
    양식("양식"),
    아시아("아시아"),
    이탈리안("이탈리안"),
    멕시칸("멕시칸"),
    치킨("치킨"),
    카페("카페"),
    미확인("미확인");

    private String value;

    Category(String category) {
        value = category;
    }
}