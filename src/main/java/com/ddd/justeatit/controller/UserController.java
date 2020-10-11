package com.ddd.justeatit.controller;

import com.ddd.justeatit.dto.RestaurantDto;
import com.ddd.justeatit.dto.UserDto;
import com.ddd.justeatit.dto.UserPreferInfoDto;
import com.ddd.justeatit.dto.UserVisitInfoDto;
import com.ddd.justeatit.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
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

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Integer> createUser(@RequestBody() UserDto userDto,
                                                     HttpServletRequest req) throws Exception {
        return userService.createUser(userDto);
    }

    @GetMapping(value = "/{userId}/userFriend")
    public ResponseEntity<List<String>> readUserFriend(@PathVariable("userId") String userId, HttpServletRequest req) throws Exception {
        return userService.readUserFriendByUserId(userId);
    }

    @PostMapping(value = "/{userId}")
    public ResponseEntity<Integer> addUserFriend(@PathVariable("userId") String userId, @RequestParam(value="friendId") String friendId) {
        return userService.addUserFriend(userId, friendId);
    }

    @GetMapping(value = "/{userId}/userPreferInfo")
    public ResponseEntity<UserPreferInfoDto> readUserPreferInfo(@PathVariable("userId") String userId, HttpServletRequest req) throws Exception {
        return userService.readUserPreferInfoByUserId(userId);
    }

    @GetMapping(value = "/{userId}/userVisitInfo")
    public ResponseEntity<ArrayList<UserVisitInfoDto>> readUserVisitInfo(@PathVariable("userId") String userId, HttpServletRequest req) throws Exception {
        return userService.readUserVisitInfoByUserId(userId);
    }
}
