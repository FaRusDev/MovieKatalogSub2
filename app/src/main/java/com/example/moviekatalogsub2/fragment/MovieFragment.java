package com.example.moviekatalogsub2.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.moviekatalogsub2.DetailActivity;
import com.example.moviekatalogsub2.R;
import com.example.moviekatalogsub2.adapter.MovieRecyclerAdapter;
import com.example.moviekatalogsub2.model.MovieModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private String[] judulMovie;
    private String[] jadwalMovie;
    private String[] rateMovie;
    private String[] descMovie;
    private TypedArray posterMovie;
    private MovieRecyclerAdapter adapter;
    ArrayList<MovieModel> movieModels;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_movie, container, false);

        adapter = new MovieRecyclerAdapter(this.getContext());

        init();
        tambahData();
        setRecyclerView(root);

        return root;
    }


    private void init(){
        judulMovie = getResources().getStringArray(R.array.movie_title);
        jadwalMovie = getResources().getStringArray(R.array.movie_schedule);
        rateMovie = getResources().getStringArray(R.array.movie_rate);
        descMovie = getResources().getStringArray(R.array.movie_description);
        posterMovie = getResources().obtainTypedArray(R.array.movie_poster);
    }

    private void tambahData(){
        movieModels = new ArrayList<>();

       for (int posisi=0;posisi < judulMovie.length;posisi++){
            MovieModel movie = new MovieModel();

            movie.setPosterMovie(posterMovie.getResourceId(posisi,-1));
            movie.setDescMovie(descMovie[posisi]);
            movie.setJadwalMovie(jadwalMovie[posisi]);
            movie.setJudulMovie(judulMovie[posisi]);
            movie.setRateMovie(rateMovie[posisi]);

            movieModels.add(movie);
        }

        adapter.setMovieModels(movieModels);
    }

    public void setRecyclerView(View v){
        RecyclerView rv = v.findViewById(R.id.movie_recycler);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv.setHasFixedSize(true);

        adapter.setOnItemClickListenerCustom(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView.ViewHolder vh = (RecyclerView.ViewHolder) v.getTag();
                int position = vh.getAdapterPosition();

                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("Extra",movieModels.get(position));
                startActivity(intent);

                Toast.makeText(getContext(),movieModels.get(position).getJudulMovie(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
