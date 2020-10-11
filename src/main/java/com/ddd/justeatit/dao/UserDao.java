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

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcOperations jdbc;

    public int createUser(UserDto user) {
        try {
            SqlParameterSource params = new BeanPropertySqlParameterSource(user);
            return jdbc.update("insert into user (userId, userName, userNickName, userEmail, userFriend, userPreferInfo, userVisitInfo) values (:userId, :userName, :userNickName, :userEmail, [], :userPreferInfo, {})", params);
        } catch (EmptyResultDataAccessException e) {
            return -1;
        }
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

    public String readUserFriendsByUserId(String userId) {
        try {
            SqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            return jdbc.queryForObject("select userFriend from user where userId=:userId", params, String.class);
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    public int deleteUser(String userId) {
        try {
            SqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId);
            return jdbc.update("delete from user where userId=:userId", params);
        } catch (EmptyResultDataAccessException e) {
            return -1;
        }
    }

    public List<UserDto> readAllUsers() {
        return jdbcTemplate.query("select userId, userName, userNickName, userFriend, userPreferInfo, userVisitInfo from user", new UserMapper());
    }

    public int addFriend(String userId, String friendId) {
        try {
            String currentFriends = readUserFriendsByUserId(userId);
            if (currentFriends == null) {
                // there is no userId
                return -1;
            }

            if (currentFriends.length() == 2)  {
                friendId = new StringBuilder(friendId).insert(0, "[").append("]").toString();
            } else {
                friendId = new StringBuilder(currentFriends).insert(currentFriends.length()-1, "," + friendId).toString();
            }

            SqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId)
                    .addValue("friendId", friendId);
            return jdbc.update("update user SET friendId = :friendId WHERE userId = :userId", params);
        } catch (EmptyResultDataAccessException e) {
            return -1;
        }
    }

    public int deleteFriend(String userId, String friendId) {
        try {
            String currentFriends = readUserFriendsByUserId(userId);
            if (currentFriends == null) {
                // there is no userId
                return -1;
            }

            if (currentFriends.length() == 2)  {
                return -2;
            } else {
                if (currentFriends.contains(friendId)) {
                    String[] friends = currentFriends.substring(1, currentFriends.length()-1).split(",");
                    ArrayList<String> postFriends = new ArrayList<>();
                    for (String friend : friends) {
                        if (!friend.equals(friendId)) {
                            postFriends.add(friend);
                        }
                    }
                    friendId = new StringBuilder(String.join(",", postFriends)).insert(0, "[").append("]").toString();
                }
            }

            SqlParameterSource params = new MapSqlParameterSource().addValue("userId", userId)
                    .addValue("friendId", friendId);
            return jdbc.update("update user SET friendId = :friendId WHERE userId = :userId", params);
        } catch (EmptyResultDataAccessException e) {
            return -1;
        }
    }
}
