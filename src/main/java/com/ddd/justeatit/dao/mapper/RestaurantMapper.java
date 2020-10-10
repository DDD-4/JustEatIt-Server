package com.ddd.justeatit.dao.mapper;

import com.ddd.justeatit.Util.JsonParser;
import com.ddd.justeatit.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantMapper implements RowMapper<RestaurantDto> {
    @Autowired
    JsonParser jsonParser;

    public RestaurantDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        String restaurantId = rs.getString("restaurantId");
        String restaurantName = rs.getString("restaurantName");
        String restaurantAddress = rs.getString("restaurantAddress");
        String restaurantCategory = rs.getString("restaurantCategory");
        String restaurantWeight = rs.getString("restaurantWeight");
        Integer restaurantPrice = rs.getInt("restaurantPrice");
        Double restaurantXcord = rs.getDouble("restaurantXcord");
        Double restaurantYcord = rs.getDouble("restaurantYcord");

        return new RestaurantDto(restaurantId, restaurantName, restaurantAddress, restaurantCategory, restaurantWeight, restaurantPrice, restaurantXcord, restaurantYcord);
    }
}
