package com.ddd.justeatit.dto;

import com.ddd.justeatit.Util.JsonParser;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonBooleanFormatVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserVisitInfoDto {
    private String restaurantId;
    private String restaurantName;
    private LocalDateTime visitDay;
    private Integer visitCnt;
    private Integer likeCnt;
    private Integer dislikeCnt;

    public UserVisitInfoDto(String json) {
        JSONObject jsonObject = JsonParser.string2json(json);

        restaurantId = jsonObject.getString("restaurantId");
        restaurantName = jsonObject.getString("restaurantName");
        visitDay = LocalDateTime.parse(jsonObject.get("visitDay").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        likeCnt = jsonObject.getInt("likeCnt");
        dislikeCnt = jsonObject.getInt("dislikeCnt");
    }

    public String toString() {
        return JsonParser.json2string(this);
    }
}
