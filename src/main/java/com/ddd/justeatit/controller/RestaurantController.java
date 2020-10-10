package com.ddd.justeatit.controller;

import com.ddd.justeatit.dto.RestaurantDto;
import com.ddd.justeatit.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/{restaurantId}")
    @ResponseBody
    public ResponseEntity<RestaurantDto> readRestaurant(@PathVariable("restaurantId") String restaurantId, HttpServletRequest req) throws Exception {
        return restaurantService.readRestaurantByRestaurantId(restaurantId);
    }
}
