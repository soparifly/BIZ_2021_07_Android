package com.kimbyulook.navermovie.service.impl
        ;

import android.text.method.MovementMethod;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kimbyulook.navermovie.adapter.MovieViewAdapter;
import com.kimbyulook.navermovie.config.NaverSecret;
import com.kimbyulook.navermovie.model.NaverMovieDTO;
import com.kimbyulook.navermovie.model.NaverParentDTO;
import com.kimbyulook.navermovie.service.NaverMovieService;
import com.kimbyulook.navermovie.service.RetrofitAPIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NaverMovieServiceImplV1 implements NaverMovieService {
    private RecyclerView recyclerView;

    public NaverMovieServiceImplV1(RecyclerView recyclerView) {
            this.recyclerView  = recyclerView;
    }

    @Override
    public NaverMovieDTO getMovie(String search) {
        Log.d("Naver Service","Start");

        Call<NaverParentDTO> retrofitReturn = RetrofitAPIClient.getApiClient().getMovie(
                NaverSecret.CLIENT_ID,
                NaverSecret.CLIENT_SECTRET,
                search,
                1,
                10);
        retrofitReturn.enqueue(new Callback<NaverParentDTO>() {
            @Override
            public void onResponse(Call<NaverParentDTO> call, Response<NaverParentDTO> response) {
                int resCode = response.code();
                if(resCode < 300){
                    Log.d("네이버 응답 데이터 : ",
                            response.body().toString());
                    NaverParentDTO naverParentDTO = response.body();

                    List<NaverMovieDTO> movieDTOList = naverParentDTO.items;

                    MovieViewAdapter movieViewAdapter = new MovieViewAdapter(movieDTOList);

                    Log.d("Adapter", movieViewAdapter.toString());
                    Log.d("recyclerView" , recyclerView.toString());

                    recyclerView.setAdapter(movieViewAdapter);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                            recyclerView.getContext()
                    );
                    recyclerView.setLayoutManager(layoutManager);
                } else {
                    Log.d("오류발생 :  ",response.toString());

                }
            }

            @Override
            public void onFailure(Call<NaverParentDTO> call, Throwable t) {

            }
        });

        return null;
    }
}

