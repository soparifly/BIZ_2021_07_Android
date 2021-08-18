package com.kimbyulook.navermovie.service;

import com.kimbyulook.navermovie.model.NaverParentDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface NaverRetrofit {

    public Call getMovie();

    @GET("movie.json")
    public Call<NaverParentDTO> getMovie(
            @Header("X-Naver-Client-Id") String ClientId,
            @Header("X-Naver-Client-Secret") String ClientSecret,
            @Query("query") String query,
            @Query("start") int start,
            @Query("display") int dispaly

    );
}
