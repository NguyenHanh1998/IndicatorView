package com.example.hanh.learningabstract.data.remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostService {

    @POST("posts")
    @FormUrlEncoded// các yêu cầu sẽ có kiểu MIME của nó (một tiêu đề trường xác định các định dạng của body của một yêu cầu
        // hoặc phản hồi HTTP) được thiết lập thành application/x-www-form-urlencoded
        // và đồng thời tên trường và giá trị của nó sẽ là UTF-8 encoded trước URI-encoded.
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") Integer userId,
                        @Field("id") Integer id);

}
