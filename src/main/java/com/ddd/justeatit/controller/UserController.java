package com.ddd.justeatit.controller;

import com.ddd.justeatit.dto.UserDto;
import com.ddd.justeatit.dto.UserPreferInfoDto;
import com.ddd.justeatit.dto.UserVisitInfoDto;
import com.ddd.justeatit.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping
//    @ResponseBody
//    public int createUser(@RequestBody JSONObject user, HttpServletRequest req) throws Exception {
//        userService.createUser(user);
//    }

    @GetMapping(value = "/{userId}")
    @ResponseBody
    public ResponseEntity<UserDto> readUser(@PathVariable("userId") String userId, HttpServletRequest req) throws Exception {
        return userService.readUserByUserId(userId);
    }

    @GetMapping(value = "/{userId}/userFriend")
    public ResponseEntity<List<String>> readUserFriend(@PathVariable("userId") String userId, HttpServletRequest req) throws Exception {
        return userService.readUserFriendByUserId(userId);
    }

    @GetMapping(value = "/{userId}/userPreferInfo")
    public ResponseEntity<UserPreferInfoDto> readUserPreferInfo(@PathVariable("userId") String userId, HttpServletRequest req) throws Exception {
        return userService.readUserPreferInfoByUserId(userId);
    }

    @GetMapping(value = "/{userId}/userVisitInfo")
    public ResponseEntity<UserVisitInfoDto> readUserVisitInfo(@PathVariable("userId") String userId, HttpServletRequest req) throws Exception {
        return userService.readUserVisitInfoByUserId(userId);
    }
}
