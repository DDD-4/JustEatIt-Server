package com.ddd.justeatit.service;

import com.ddd.justeatit.dao.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsersService {
    @Autowired
    private UserDao userDao;
}
