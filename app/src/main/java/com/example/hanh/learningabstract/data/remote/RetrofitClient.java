package com.example.hanh.learningabstract.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl)
    {
        if(retrofit == null)
        {
            //tao mot doi tuong bang casch su dung lop Retrofit.Builder(), roi cau hinh no voi mot url co so
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
