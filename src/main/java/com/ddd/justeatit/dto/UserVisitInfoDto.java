package com.ddd.justeatit.dto;

import com.ddd.justeatit.Util.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserVisitInfoDto {
    @Autowired
    JsonParser jsonParser;

    private String restaurantId;
    private String restaurantName;
    private LocalDateTime visitDay;
    private Integer visitCnt;
    private Integer likeCnt;
    private Integer dislikeCnt;

    public UserVisitInfoDto(String json) {

    }
}
