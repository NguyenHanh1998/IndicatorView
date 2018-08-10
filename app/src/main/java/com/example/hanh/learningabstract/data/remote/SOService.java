package com.example.hanh.learningabstract.data.remote;

import com.example.hanh.learningabstract.data.model.Item;
import com.example.hanh.learningabstract.data.model.SOAnswersResponse;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SOService {
    @GET("products?offset=0&limit=10")
    Call<JsonElement> getAnswer();

    @GET("answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswer(@Query("tagged") String tags);


}
