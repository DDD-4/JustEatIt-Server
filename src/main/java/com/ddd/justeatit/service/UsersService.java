package com.ddd.justeatit.service;

import com.ddd.justeatit.dao.UserDao;
import com.ddd.justeatit.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsersService {
    @Autowired
    private UserDao userDao;

    public ResponseEntity<UserDto> createUser(String userId, String userName, String userEmail) {
        UserDto userDto = userDao.
    }
}
