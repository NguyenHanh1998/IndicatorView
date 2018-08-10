package com.example.hanh.learningabstract.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Option  {

    private String optionName;
    private List<String> optionList = new ArrayList<>();

    @SerializedName("Color")
    @Expose
    private List<String> color = null;
    @SerializedName("Material")
    @Expose
    private List<String> material = null;
    @SerializedName("Type")
    @Expose
    private List<String> type = null;
    @SerializedName("Storage")
    @Expose
    private List<String> storage = null;

    public Option(JSONObject json) {
        Iterator<String> iterator = json.keys();
        optionName = iterator.next();
        JSONArray array = json.optJSONArray(optionName);
        for (int i = 0; i < array.length(); i++) {
            try {
                optionList.add(array.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public List<String> getMaterial() {
        return material;
    }

    public void setMaterial(List<String> material) {
        this.material = material;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<String> getStorage() {
        return storage;
    }

    public void setStorage(List<String> storage) {
        this.storage = storage;
    }
}
