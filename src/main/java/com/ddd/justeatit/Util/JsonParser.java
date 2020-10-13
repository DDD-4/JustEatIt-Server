package com.ddd.justeatit.Util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;

public class JsonParser {
    @Autowired
    private static final Gson gson = new Gson();

    public ArrayList<String> string2list(String target) {
        ArrayList<String> result = gson.fromJson(target, new TypeToken<ArrayList<String>>(){}.getType());
        return result;
    }

    public static JSONObject string2json(String target) {
        return new JSONObject(target);
    }

    public static JSONArray string2jsonArray(String target) {
        return new JSONArray(target);
    }

    public static String json2string(Object object) {
        return gson.toJson(object);
    }
}
