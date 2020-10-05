package com.ddd.justeatit.dao;

import com.ddd.justeatit.dao.mapper.UserMapper;
import com.ddd.justeatit.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcOperations jdbc;

    public int createUser(UserDto user) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(user);
        return jdbc.update("insert into user (userId, userName, userNickName, userEmail, userFriend, userPreferInfo, userVisitInfo) values (:userId, :userName, :userNickName, :userEmail, :userFriend, :userPreferInfo, :userVisitInfo)", params);
    }

    public UserDto readUserByUserId(String userId) {
        try {
            SqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            return jdbc.queryForObject("select userId, userName, userNickName, userFriend, userPreferInfo, userVisitInfo from user where userId=:userId", params, new UserMapper());
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<UserDto> readAllUsers() {
        return jdbcTemplate.query("select userId, userName, userNickName, userFriend, userPreferInfo, userVisitInfo from user", new UserMapper());
    }
}
