package com.example.woowahan.retrofitsample.network.deserializer;

import com.example.woowahan.retrofitsample.network.model.Blog;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jihoon on 2016. 12. 31..
 */

public class CustomDeserializer implements JsonDeserializer<List<Blog>> {

    @Override
    public List<Blog> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();

        JsonElement jsonElement = json.getAsJsonObject().get("items");
        List<Blog> items = new ArrayList<>();
        for (JsonElement element : jsonElement.getAsJsonArray()) {
            items.add(gson.fromJson(element, Blog.class));
        }
        Type listType = new TypeToken<List<Blog>>(){}.getType();

//        return gson.fromJson(jsonElement, listType);
        return items;
    }
}
