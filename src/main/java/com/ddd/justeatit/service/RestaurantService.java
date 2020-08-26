package com.ddd.justeatit.service;

import com.ddd.justeatit.dao.RestaurantDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RestaurantService {
    @Autowired
    private RestaurantDao restaurantDao;
}
