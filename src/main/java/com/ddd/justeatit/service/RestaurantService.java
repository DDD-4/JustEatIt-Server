package com.ddd.justeatit.service;

import com.ddd.justeatit.dao.RestaurantDao;
import com.ddd.justeatit.dto.RestaurantDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RestaurantService {
    @Autowired
    private RestaurantDao restaurantDao;

    public RestaurantDto readRestaurantById(String restaurantId) throws Exception {
        return restaurantDao.readRestaurantById(restaurantId);
    }
}
