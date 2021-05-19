package com.iamyeong.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private Retrofit retrofit;
    private String baseURL;

    public RetrofitManager() {}

    public RetrofitManager(String baseUrl) {
        this.baseURL = baseUrl;
    }

    public DataHolder requestRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataHolder holder = retrofit.create(DataHolder.class);

        return holder;
    }

}
