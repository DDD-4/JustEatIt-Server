package com.ddd.justeatit.controller;

import com.ddd.justeatit.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurant/{restaurantId}")
    public Long getUser(@PathVariable("restaurantId") String restaurantId){


        return 123456L;
    }
}
