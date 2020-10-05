package com.ddd.justeatit.dao.mapper;

import com.ddd.justeatit.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserDto> {
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        String userId = rs.getString("userId");
        String userName = rs.getString("userName");
        String userNickName = rs.getString("userNickName");
        String userEmail = rs.getString("userEmail");
        Integer userBanDay = rs.getInt("userBanDay");
        String userFriend = rs.getString("userFriend");
        String userPreferInfo = rs.getString("userPreferInfo");
        String userVisitInfo = rs.getString("userVisitInfo");

        return new UserDto(userId, userName, userNickName, userEmail, userBanDay, userFriend, userPreferInfo, userVisitInfo);
    }
}
