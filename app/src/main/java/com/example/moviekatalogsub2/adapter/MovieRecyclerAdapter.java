package com.example.moviekatalogsub2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviekatalogsub2.R;
import com.example.moviekatalogsub2.model.MovieModel;

import java.util.ArrayList;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.AdapterViewHolder> {

    private Context ctx;
    private ArrayList<MovieModel> movieModels;
    private View.OnClickListener listener;

    public void setOnItemClickListenerCustom(View.OnClickListener itemClickListenerCustom){
        this.listener = itemClickListenerCustom;
    }


    private ArrayList<MovieModel> getMovieModels() {
        return movieModels;
    }

    public void setMovieModels(ArrayList<MovieModel> movieModels) {
        this.movieModels = movieModels;
    }

    public MovieRecyclerAdapter(Context context) {
        this.ctx = context;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(ctx).inflate(R.layout.recycler_list_item,viewGroup,false);

        return new AdapterViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder adapterViewHolder, int i) {
        adapterViewHolder.bindHolder(i);
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView judulView;
        private ImageView posterView;

        AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            judulView = itemView.findViewById(R.id.judul_item);
            posterView = itemView.findViewById(R.id.poster_item);

            itemView.setTag(this);
            itemView.setOnClickListener(listener);
        }

        void bindHolder(int position){
            judulView.setText(getMovieModels().get(position).getJudulMovie());
            Glide.with(ctx)
                    .load(getMovieModels().get(position).getPosterMovie())
                    .into(posterView);
        }
    }
}
