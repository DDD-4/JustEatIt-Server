package com.ddd.justeatit.service;

import com.ddd.justeatit.dao.RestaurantDao;
import com.ddd.justeatit.dto.RestaurantDto;
import com.ddd.justeatit.dto.UserDto;
import com.ddd.justeatit.dto.UserPreferInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RestaurantService {
    @Autowired
    private RestaurantDao restaurantDao;

    public ResponseEntity<RestaurantDto> readRestaurantByRestaurantId(String restaurantId) {
        RestaurantDto restaurantDto = restaurantDao.readRestaurantByRestaurantId(restaurantId);
        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
    }

    public ResponseEntity<RestaurantDto> readRestaurantByUserPreferInfo(UserPreferInfoDto userPreferInfoDto) {
        RestaurantDto restaurantDto = restaurantDao.readRestaurantByUserPreferInfo(userPreferInfoDto);
        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);

    }
}
