package com.ddd.justeatit.dao;

import com.ddd.justeatit.dao.mapper.RestaurantMapper;
import com.ddd.justeatit.dto.RestaurantDto;
import com.ddd.justeatit.dto.UserPreferInfoDto;
import com.ddd.justeatit.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcOperations jdbc;

    public int createRestaurant(RestaurantDto Restaurant) {
        return 0;
    }

    public RestaurantDto readRestaurantByRestaurantId(String restaurantId){
        try {
            SqlParameterSource params = new MapSqlParameterSource("restaurantId", restaurantId);
            return jdbc.queryForObject("select restaurantName, restaurantId, restaurantAddress, " +
                    "restaurantType, restaurantWeight, restaurantPrice, restaurantXcord, restaurantYcord " +
                    "from restaurant where restaurantId=:restaurantId", params, new RestaurantMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public RestaurantDto readRestaurantByUserPreferInfo(UserPreferInfoDto userPreferInfoDto) {
        try {
            SqlParameterSource params = new MapSqlParameterSource().addValue("weight", userPreferInfoDto.getFoodWeight())
                    .addValue("category",userPreferInfoDto.getFoodCategory())
                    .addValue("priceMin",userPreferInfoDto.getFoodPriceMin())
                    .addValue("priceMax",userPreferInfoDto.getFoodPriceMax());

            return jdbc.queryForObject("select restaurantName, restaurantId, restaurantAddress, " +
                    "restaurantType, restaurantWeight, restaurantPrice, restaurantXcord, restaurantYcord " +
                    "from restaurant where restaurantWeight in (:weight) and restaurantCategory in (:category)" +
                    "and restaurantPrice between :priceMin and :priceMax order by rand() limit 1", params, new RestaurantMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
