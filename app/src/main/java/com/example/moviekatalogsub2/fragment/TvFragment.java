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
import com.example.moviekatalogsub2.adapter.TvRecyclerAdapter;
import com.example.moviekatalogsub2.model.MovieModel;
import com.example.moviekatalogsub2.model.TvModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {


    private String[] judulTv;
    private String[] rateTv;
    private String[] descTv;
    private TypedArray posterTv;
    private TvRecyclerAdapter adapter;
    ArrayList<TvModel> tvModels;


    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tv, container, false);

        adapter = new TvRecyclerAdapter(this.getContext());

        init();
        tambahData();
        setRecyclerView(rootView);

        return rootView;
    }


    private void init(){
        judulTv = getResources().getStringArray(R.array.tv_title);
        rateTv = getResources().getStringArray(R.array.tv_rate);
        descTv = getResources().getStringArray(R.array.tv_description);
        posterTv = getResources().obtainTypedArray(R.array.tv_poster);
    }

    private void tambahData(){
        tvModels = new ArrayList<>();

        for (int posisi=0;posisi < judulTv.length;posisi++){
            TvModel tv = new TvModel();

            tv.setPosterTv(posterTv.getResourceId(posisi,-1));
            tv.setDescTv(descTv[posisi]);
            tv.setJudulTv(judulTv[posisi]);
            tv.setRateTv(rateTv[posisi]);

            tvModels.add(tv);
        }

        adapter.setTvModels(tvModels);
    }

    public void setRecyclerView(View v){
        RecyclerView rv = v.findViewById(R.id.tv_recycler);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rv.setHasFixedSize(true);

        adapter.setOnItemClickListenerCustom(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView.ViewHolder vh = (RecyclerView.ViewHolder) v.getTag();
                int position = vh.getAdapterPosition();

                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("Extra",tvModels.get(position));
                startActivity(intent);

                Toast.makeText(getContext(),tvModels.get(position).getJudulTv(),Toast.LENGTH_SHORT).show();
            }
        });
    }


}
