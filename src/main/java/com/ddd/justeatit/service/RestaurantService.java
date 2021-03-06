package com.ddd.justeatit.service;

import com.ddd.justeatit.dao.RestaurantDao;
import com.ddd.justeatit.dto.RestaurantDto;
import com.ddd.justeatit.dto.UserPreferInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

    @Transactional(rollbackFor = {Exception.class})
    public int createRestaurant(RestaurantDto restaurantDto) throws Exception {
        if (StringUtils.isEmpty(restaurantDto.getRestaurantId()) || StringUtils.isEmpty(restaurantDto.getRestaurantName())) {
            // log.error("createProject - Wrong API Input");
            throw new Exception();
        }
        return restaurantDao.createRestaurant(restaurantDto);
    }

    public boolean isRestaurantExist(String restaurantId) throws Exception {
        return restaurantDao.readRestaurantByRestaurantId(restaurantId) == null;
    }
}
