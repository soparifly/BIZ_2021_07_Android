package com.kimbyulook.mylibery.apdapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kimbyulook.mylibery.model.BookDTO;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter {

    private List<BookDTO> bookList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return bookList == null ? 0 : bookList.size();
    }
    /*
    각 데이터 item 을 표현하기 위한 View객체 생성하기
     */
    public static class BookViewHolder extends  RecyclerView.ViewHolder{

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
