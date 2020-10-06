package com.ddd.justeatit.dao.mapper;

import com.ddd.justeatit.Util.JsonParser;
import com.ddd.justeatit.dto.UserDto;
import com.ddd.justeatit.dto.UserPreferInfoDto;
import com.ddd.justeatit.dto.UserVisitInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class UserMapper implements RowMapper<UserDto> {
    @Autowired
    JsonParser jsonParser;

    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        String userId = rs.getString("userId");
        String userName = rs.getString("userName");
        String userNickName = rs.getString("userNickName");
        String userEmail = rs.getString("userEmail");
        Integer userBanDay = rs.getInt("userBanDay");
        ArrayList<String> userFriend = jsonParser.string2list(rs.getString("userFriend"));
        UserPreferInfoDto userPreferInfo = new UserPreferInfoDto(rs.getString("userPreferInfo"));
        UserVisitInfoDto userVisitInfo = new UserVisitInfoDto(rs.getString("userVisitInfo"));

        return new UserDto(userId, userName, userNickName, userEmail, userBanDay, userFriend, userPreferInfo, userVisitInfo);
    }
}
