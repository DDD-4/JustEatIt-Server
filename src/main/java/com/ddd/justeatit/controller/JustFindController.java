package com.ddd.justeatit.controller;

import com.ddd.justeatit.dto.RestaurantDto;
import com.ddd.justeatit.dto.UserPreferInfoDto;
import com.ddd.justeatit.service.RestaurantService;
import com.ddd.justeatit.service.UserService;
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
