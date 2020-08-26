package com.ddd.justeatit.dao.mapper;

import com.ddd.justeatit.dto.RestaurantDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantMapper implements RowMapper<RestaurantDto> {
    public RestaurantDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        String restaurantId = rs.getString("restaurant_id");
        String restaurantName = rs.getString("restaurant_name");
        String restaurantAddress = rs.getString("restaurant_adr");
        String restaurantType = rs.getString("restaurant_type");
        String restaurantWeight = rs.getString("restaurant_weight");
        Integer restaurantPrice = rs.getInt("restaurant_price");

        return new RestaurantDto(restaurantId, restaurantName, restaurantAddress, restaurantType, restaurantWeight, restaurantPrice);
    }
}
