package com.example.hanh.learningabstract.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class ItemInfo {

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("tags")
    @Expose
    private String tags;
    public ItemInfo(JSONObject jsonObject) {
        thumbnail = jsonObject.optString("thumbnail");
        tags = jsonObject.optString("tags");
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

}
