package com.iamyeong.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataHolder {

    @GET("posts")
    Call<List<Post>> getPosts();

}
