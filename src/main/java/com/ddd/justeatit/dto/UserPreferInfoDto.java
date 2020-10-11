package com.ddd.justeatit.dto;

import com.ddd.justeatit.Util.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserPreferInfoDto {
    private List<String> foodWeight;
    private List<String> foodCategory;
    private Integer foodPriceMin;
    private Integer foodPriceMax;

    public UserPreferInfoDto(String json) {
        JSONObject jsonObject = JsonParser.string2json(json);
        JSONArray jsonArray = jsonObject.getJSONArray("foodWeight");
        for (Object object : jsonArray) {
            foodWeight.add(object.toString());
        }
        jsonArray = jsonObject.getJSONArray("foodCategory");
        for (Object object : jsonArray) {
            foodCategory.add(object.toString());
        }
        foodPriceMin = jsonObject.getInt("foodPriceMin");
        foodPriceMax = jsonObject.getInt("foodPriceMax");
    }

    public String toString() {
        return JsonParser.json2string(this);
    }
}
