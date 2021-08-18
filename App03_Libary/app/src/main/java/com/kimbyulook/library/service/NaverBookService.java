package com.kimbyulook.library.service;

import com.kimbyulook.library.model.NaverBookDTO;

public interface NaverBookService {
    public NaverBookDTO getBooks(String search);
}
