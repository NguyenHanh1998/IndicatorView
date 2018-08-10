package com.example.hanh.learningabstract.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Product {

    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("store_id")
    @Expose
    private Integer storeId;
    @SerializedName("item_info")
    @Expose
    private ItemInfo itemInfo;
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<>();
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("rating_average")
    @Expose
    private Integer ratingAverage;
    @SerializedName("total_review")
    @Expose
    private Integer totalReview;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("short_description")
    @Expose
    private Object shortDescription;
    @SerializedName("variants")
    @Expose
    private List<Variant> variants = new ArrayList<>();
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("options")
    @Expose
    private List<Option> options = new ArrayList<>();
    @SerializedName("total_rating")
    @Expose
    private Integer totalRating;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("view_number")
    @Expose
    private Integer viewNumber;
    @SerializedName("buy_number")
    @Expose
    private Integer buyNumber;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("compared_price")
    @Expose
    private Double comparedPrice;
    @SerializedName("shipping_price")
    @Expose
    private Integer shippingPrice;
    @SerializedName("shipping_day")
    @Expose
    private Object shippingDay;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Product(JSONObject jsonObject) {

        productId = jsonObject.optInt("product_id");
        storeId = jsonObject.optInt("store_id");
        title = jsonObject.optString("title");
        description = jsonObject.optString("description");
        parseOptions(jsonObject.optJSONArray("options"));
        parseImages(jsonObject.optJSONArray("images"));
        thumbnail = jsonObject.optString("thumbnail");
        category = jsonObject.optString("category");
        parseVariants(jsonObject.optJSONArray("variants"));
        parseItemInfo(jsonObject.optJSONObject("item_info"));
       // ratingAverage = (jsonObject.optDouble("rating_average"));
        totalReview = (jsonObject.optInt("total_review"));
        createdAt = (jsonObject.optString("created_at"));
        updatedAt = (jsonObject.optString("updated_at"));
       // totalRating = (jsonObject.optDouble("total_rating"));
    }

    private void parseOptions(JSONArray array) {

        if (array == null) {
            return;
        }

        int length = array.length();
        for (int i = 0; i < length; i++) {
            Option option = new Option(array.optJSONObject(i));
            options.add(option);
        }
    }
    private void parseItemInfo(JSONObject jsonObject) {
        if(jsonObject == null)
            return;
        itemInfo = new ItemInfo(jsonObject);
    }

    private void parseImages(JSONArray array) {
        if(array == null)
        {
            return;
        }
        int length = array.length();
        for (int i = 0; i < length; i++) {
            Image image = new Image(array.optJSONObject(i));
            images.add(image);

        }
    }

    private void parseVariants(JSONArray array) {
        if(array == null)
        {
            return;
        }
        int length = array.length();
        for (int i = 0; i < length; i++) {
            Variant variant = new Variant(array.optJSONObject(i));
            variants.add(variant);
        }
    }
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(ItemInfo itemInfo) {
        this.itemInfo = itemInfo;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(Integer ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public Integer getTotalReview() {
        return totalReview;
    }

    public void setTotalReview(Integer totalReview) {
        this.totalReview = totalReview;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(Object shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Integer getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Integer totalRating) {
        this.totalRating = totalRating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(Integer viewNumber) {
        this.viewNumber = viewNumber;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getComparedPrice() {
        return comparedPrice;
    }

    public void setComparedPrice(Double comparedPrice) {
        this.comparedPrice = comparedPrice;
    }

    public Integer getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Integer shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public Object getShippingDay() {
        return shippingDay;
    }

    public void setShippingDay(Object shippingDay) {
        this.shippingDay = shippingDay;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
