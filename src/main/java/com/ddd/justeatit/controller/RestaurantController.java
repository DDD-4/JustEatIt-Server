package com.ddd.justeatit.controller;

import com.ddd.justeatit.dto.RestaurantDto;
import com.ddd.justeatit.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

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

    @PostMapping(value = "/tasks", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap<String, Integer> createRestaurant(@RequestBody() RestaurantDto restaurantDto,
                                               HttpServletRequest req) throws Exception {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("taskId", restaurantService.createRestaurant(restaurantDto));
        return map;
    }
}
