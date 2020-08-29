package cn.czynb.hypixelbot.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Json {

    public static String getFieldOrNA(String field, JsonObject json) {
        JsonElement value = json.get(field);
        if (value != null) {
            // If the field was found, return its value
            return value.getAsString();
        } else {
            // Otherwise, return "N/A"
            return "N/A";
        }
    }

}
