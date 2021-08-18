package com.kimbyulook.navermovie.service;

import com.kimbyulook.navermovie.config.NaverSecret;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPIClient {

    public static NaverRetrofit getApiClient(){
        NaverRetrofit naverRetrofit =  getConnection().create(NaverRetrofit.class);
           return naverRetrofit;
    }
    private static Retrofit getConnection() {
        Retrofit retrofit
                = new Retrofit.Builder()
                .baseUrl(NaverSecret.NAVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}





