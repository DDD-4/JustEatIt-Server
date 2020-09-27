package com.ddd.justeatit.Util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashSet;

public class JsonParser {
    private final Gson gson = new Gson();
    public ArrayList<String> string2list(String target) {
        ArrayList<String> result = gson.fromJson(target, new TypeToken<ArrayList<String>>(){}.getType());
        return result;
    }

    public HashSet<String> string2set(String target) {
        HashSet<String> result = gson.fromJson(target, new TypeToken<HashSet<String>>(){}.getType());
        return result;
    }
}
