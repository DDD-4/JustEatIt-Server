package com.ddd.justeatit.dao.mapper;

import com.ddd.justeatit.Util.JsonParser;
import com.ddd.justeatit.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class UserMapper implements RowMapper<UserDto> {
    @Autowired
    JsonParser jsonParser = new JsonParser();

    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        String userId = rs.getString("userId");
        String userName = rs.getString("userName");
        String userNickName = rs.getString("userNickName");
        String userEmail = rs.getString("userEmail");
        ArrayList<String> userFriend = jsonParser.string2list(rs.getString("userFriend"));
        ArrayList<String> userPreferInfo = jsonParser.string2list(rs.getString("userPreferInfo"));
        HashSet<String> userVisitInfo = jsonParser.string2set(rs.getString("userVisitInfo"));

        return new UserDto(userId, userName, userNickName, userEmail, userFriend, userPreferInfo, userVisitInfo);
    }
}
