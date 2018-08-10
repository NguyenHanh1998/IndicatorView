package com.example.hanh.learningabstract.data.remote;

import android.widget.BaseAdapter;

public class ApiUtils {
    //mot lop tien ich, cung cap interface SOService den ung dung thong qua phuong thuc getSOService()

    public static final String BASE_URL1 = "https://api.jetfri.com/";

    public static final String BASE_URL2 = "http://jsonplaceholder.typicode.com/";

    public static SOService getSOService()
    {
        return RetrofitClient.getClient(BASE_URL1).create(SOService.class);
    }

    public static PostService getPostService()
    {
        return RetrofitClient.getClient(BASE_URL2).create(PostService.class);
    }
}
