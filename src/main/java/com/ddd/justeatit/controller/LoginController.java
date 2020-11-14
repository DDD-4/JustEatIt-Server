package com.ddd.justeatit.controller;

import com.ddd.justeatit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/login/{userId}/{userToken}")
    @ResponseBody
    public ResponseEntity<Integer> loginUser(@PathVariable("userId") String userId, @PathVariable("userToken") String userToken) {
        return userService.loginUser(userId, userToken);
    }

    @GetMapping(value = "/logout/{userId}/{userToken}")
    @ResponseBody
    public ResponseEntity<Integer> logoutUser(@PathVariable("userId") String userId, @PathVariable("userToken") String userToken) {
        return userService.loginUser(userId, userToken);
    }
}
