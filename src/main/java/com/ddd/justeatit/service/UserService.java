package com.ddd.justeatit.service;

import com.ddd.justeatit.dao.UserDao;
import com.ddd.justeatit.dto.UserDto;
import com.ddd.justeatit.dto.UserPreferInfoDto;
import com.ddd.justeatit.dto.UserVisitInfoDto;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public ResponseEntity<UserDto> readUserByUserId(String userId) {
        UserDto userDto = userDao.readUserByUserId(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    public ResponseEntity<List<String>> readUserFriendByUserId(String userId) {
        UserDto userDto = userDao.readUserByUserId(userId);
        List<String> userFriends = userDto.getUserFriend();
        return new ResponseEntity<>(userFriends, HttpStatus.OK);
    }

    public ResponseEntity<UserPreferInfoDto> readUserPreferInfoByUserId(String userId) {
        UserDto userDto = userDao.readUserByUserId(userId);
        UserPreferInfoDto userPreferInfo = userDto.getUserPreferInfo();
        return new ResponseEntity<>(userPreferInfo, HttpStatus.OK);
    }

    public ResponseEntity<UserVisitInfoDto> readUserVisitInfoByUserId(String userId) {
        UserDto userDto = userDao.readUserByUserId(userId);
        UserVisitInfoDto userVisitInfo = userDto.getUserVisitInfo();
        return new ResponseEntity<>(userVisitInfo, HttpStatus.OK);
    }
}