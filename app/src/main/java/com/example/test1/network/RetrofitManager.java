package com.example.test1.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static final String POST_URL = "https://jsonplaceholder.typicode.com/";
    private Retrofit retrofit;
    private static RetrofitManager retrofitManager;

    public RetrofitManager() {
        this.retrofit = new Retrofit
                .Builder()
                .baseUrl(POST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitManager getInstance(){
        if(retrofitManager == null){
            retrofitManager = new RetrofitManager();
        }
        return retrofitManager;
    }


    public Retrofit getRetrofit(){
        return retrofit;
    }
}
