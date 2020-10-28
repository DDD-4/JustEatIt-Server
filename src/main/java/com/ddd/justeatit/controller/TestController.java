package com.ddd.justeatit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //////////////////////////////////////
    /////// test api /////////
    //////////////////////////////////////

    @GetMapping("/hello")
    public String hello() {
        return "Hello Kim Lee Park";
    }

    @GetMapping("/users")
    public Long getUser(){
        return 123456L;
    }

    @GetMapping("/users/123456/username")
    public String getUserName(){
        return "김이박";
    }

    @GetMapping("/users/123456/usernickname")
    public String getUserNickName(){
        return "다잘먹";
    }

    @GetMapping("/users/123456/userfriend")
    public String getUserFriend(){
        return "{\n" +
                "  \"userFriend\": [\n" +
                "    \"111111\",\n" +
                "    \"222222\",\n" +
                "    \"333333\"\n" +
                "  ]\n" +
                "}";
    }
}
