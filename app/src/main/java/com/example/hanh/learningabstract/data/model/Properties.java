package com.example.hanh.learningabstract.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class Properties {


    @SerializedName("Color")
    @Expose
    private String color;
    @SerializedName("Storage")
    @Expose
    private String storage;
    public Properties(JSONObject jsonObject) {
        color = jsonObject.optString("Color");
        storage = jsonObject.optString("Storage");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

}
