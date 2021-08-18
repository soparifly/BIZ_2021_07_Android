package com.kimbyulook.navermovie.adapter;

import android.media.Image;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.kimbyulook.navermovie.R;
import com.kimbyulook.navermovie.model.NaverMovieDTO;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieViewAdapter extends RecyclerView.Adapter{


    private List<NaverMovieDTO> movieList;

    public MovieViewAdapter(List<NaverMovieDTO> movieList){
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.movie_item_view,parent,false);
        MovieItemHolder viewHolder = new MovieItemHolder(view);

        return viewHolder;
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieItemHolder movieItemHolder = (MovieItemHolder) holder;

        NaverMovieDTO movieDTO = movieList.get(position);

        String item_title = movieDTO.getTitle();
        Spanned sp_title = Html.fromHtml(item_title,Html.FROM_HTML_MODE_LEGACY);
        movieItemHolder.movie_item_title.setText(sp_title);


        String item_director = movieDTO.getDirector().replace("|",",");
        if(item_director.lastIndexOf(",") == item_director.length() -1){
             item_director = item_director.substring(0,item_director.length()-1);
        }

        movieItemHolder.movie_item_director.setText("감독 : " + item_director);

        String item_actor = movieDTO.getActor().replace("|",",");
        if(item_actor.lastIndexOf(",")== item_actor.length()-1){
            item_actor = item_actor.substring(0, item_actor.length()-1);
        }
        movieItemHolder.movie_item_actor.setText("배우 : " + item_actor);

        String item_userpoint = movieDTO.getUserRating();
        movieItemHolder.movie_item_userpoint.setText("평점 : " +item_userpoint);

        if(!movieDTO.getImage().isEmpty()){
            Picasso.get().load(movieDTO.getImage()).into(movieItemHolder.movie_item_image);
        }
    }

    @Override
    public int getItemCount() {
            return movieList == null ? 0 :movieList.size();
    }


    public static class MovieItemHolder extends RecyclerView.ViewHolder{
        public TextView movie_item_title;
        public ImageView movie_item_image;
        public TextView movie_item_director;
        public TextView movie_item_actor;
        public TextView movie_item_userpoint;

        public MovieItemHolder(@NonNull View itemView){
            super(itemView);
            movie_item_title = itemView.findViewById(R.id.movie_item_title);
            movie_item_image = itemView.findViewById(R.id.movie_item_image);
            movie_item_director = itemView.findViewById(R.id.movie_item_director);
            movie_item_actor = itemView.findViewById(R.id.movie_item_actor);
            movie_item_userpoint = itemView.findViewById(R.id.movie_item_userpoint);

        }
    }
}
