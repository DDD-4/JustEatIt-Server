package com.ddd.justeatit.dao;

import com.ddd.justeatit.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
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
}
