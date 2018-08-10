package com.example.hanh.learningabstract.data.model;

import android.util.Property;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.Iterator;

public class Variant {
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("compared_price")
    @Expose
    private Double comparedPrice;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("updated_at")
    @Expose
    private Integer updatedAt;
    @SerializedName("properties")
    @Expose
    private Properties properties;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("inventory")
    @Expose
    private Integer inventory;
    @SerializedName("id")
    @Expose
    private Integer id;

    public Variant(JSONObject jsonObject) {
        id = jsonObject.optInt("id");
        sku = jsonObject.optString("sku");
        inventory = jsonObject.optInt("inventory");
        price = jsonObject.optDouble("price");
        comparedPrice = jsonObject.optDouble("compared_price");
        imageUrl = jsonObject.optString("image_url");
        createdAt = jsonObject.optInt("created_at");
        updatedAt = jsonObject.optInt("updated_at");
        parseProperties(jsonObject.optJSONObject("properties"));
    }
    private void parseProperties(JSONObject jsonObject) {
        if(jsonObject == null)
            return;
        properties = new Properties(jsonObject);
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getComparedPrice() {
        return comparedPrice;
    }

    public void setComparedPrice(Double comparedPrice) {
        this.comparedPrice = comparedPrice;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
