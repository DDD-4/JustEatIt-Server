package com.ddd.justeatit.service;

import com.ddd.justeatit.dao.UserDao;
import com.ddd.justeatit.dto.UserDto;
import com.ddd.justeatit.dto.UserPreferInfoDto;
import com.ddd.justeatit.dto.UserVisitInfoDto;
import lombok.AllArgsConstructor;
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

    public ResponseEntity<Integer> createUser(UserDto userDto) {
        return new ResponseEntity<>(userDao.createUser(userDto), HttpStatus.OK);
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

    public ResponseEntity<ArrayList<UserVisitInfoDto>> readUserVisitInfoByUserId(String userId) {
        UserDto userDto = userDao.readUserByUserId(userId);
        ArrayList<UserVisitInfoDto> userVisitInfos = (ArrayList<UserVisitInfoDto>) userDto.getUserVisitInfo();
        return new ResponseEntity<>(userVisitInfos, HttpStatus.OK);
    }

    public ResponseEntity<Integer> addUserFriend(String userId, String friendId) {
        return new ResponseEntity<>(userDao.addFriend(userId, friendId), HttpStatus.OK);
    }

    public ResponseEntity<Integer> deleteUserFriend(String userId, String friendId) {
        return new ResponseEntity<>(userDao.deleteFriend(userId, friendId), HttpStatus.OK);
    }

    public ResponseEntity<Integer> updateUserPreferInfoByUserId(String userId, UserPreferInfoDto userPreferInfoDto) {
        return new ResponseEntity<>(userDao.updatePreferInfo(userId, userPreferInfoDto), HttpStatus.OK);
    }

    public ResponseEntity<Integer> loginUser(String userId, String userToken) {
        Integer result = userDao.readUserByLoginInfo(userId, userToken);
        if(result == 0) return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }
}
