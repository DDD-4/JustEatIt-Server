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

    @GetMapping(value = "/users/123456/userpreferinfo")
    public String getUserPreferInfo(){
        return "{\n" +
                "  \"userPreferInfo\": {\n" +
                "    \"foodWeight\": \"3\",\n" +
                "    \"foodCategory\": \"5\",\n" +
                "    \"foodPrice\": \"10000\"\n" +
                "  }\n" +
                "}}";
    }

    @GetMapping(value = "/users/123456/uservisitinfo")
    public String getUserVisitInfo(){
        return "{\n" +
                "  \"userVisitInfo\": {\n" +
                "    \"치킨장인\": {\n" +
                "      \"visitDay\": \"2020-08-15 02:12:23\",\n" +
                "      \"visitCnt\": \"3\"\n" +
                "    },\n" +
                "    \"피자고수\": {\n" +
                "      \"visitDay\": \"2020-08-13 01:53:33\",\n" +
                "      \"visitCnt\": \"9\"\n" +
                "    },\n" +
                "    \"떡볶이명인\": {\n" +
                "      \"visitDay\": \"2020-08-10 16:34:26\",\n" +
                "      \"visitCnt\": \"2\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }
}
