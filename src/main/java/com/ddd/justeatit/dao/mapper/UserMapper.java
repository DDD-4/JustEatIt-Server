package com.ddd.justeatit.dao.mapper;

import com.ddd.justeatit.Util.JsonParser;
import com.ddd.justeatit.dto.UserDto;
import com.ddd.justeatit.dto.UserPreferInfoDto;
import com.ddd.justeatit.dto.UserVisitInfoDto;
import org.json.JSONArray;
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
        String userToken = rs.getString("userToken");
        String userName = rs.getString("userName");
        String userNickName = rs.getString("userNickName");
        String userEmail = rs.getString("userEmail");
        Integer userBanDay = rs.getInt("userBanDay");
        ArrayList<String> userFriend = jsonParser.string2list(rs.getString("userFriend"));
        UserPreferInfoDto userPreferInfo = new UserPreferInfoDto(rs.getString("userPreferInfo"));

        JSONArray jsonArray = JsonParser.string2jsonArray(rs.getString("userVisitInfo"));
        ArrayList<UserVisitInfoDto> userVisitInfo = new ArrayList<>();
        for (Object object : jsonArray) {
            userVisitInfo.add(new UserVisitInfoDto(object.toString()));
        }

        return new UserDto(userId, userToken, userName, userNickName, userEmail, userBanDay, userFriend, userPreferInfo, userVisitInfo);
    }
}
