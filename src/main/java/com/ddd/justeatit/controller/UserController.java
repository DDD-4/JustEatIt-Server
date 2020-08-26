package com.ddd.justeatit.controller;

import com.ddd.justeatit.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UsersService usersService;





}
