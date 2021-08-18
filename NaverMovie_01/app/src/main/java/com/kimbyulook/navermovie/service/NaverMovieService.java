package com.kimbyulook.navermovie.service;

import com.kimbyulook.navermovie.model.NaverMovieDTO;

public interface NaverMovieService {
    public NaverMovieDTO getMovie(String search);
}