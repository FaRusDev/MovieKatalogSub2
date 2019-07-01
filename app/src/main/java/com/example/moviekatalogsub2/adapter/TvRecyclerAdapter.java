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
import com.example.moviekatalogsub2.model.TvModel;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class TvRecyclerAdapter extends RecyclerView.Adapter<TvRecyclerAdapter.TvViewHolder> {

    private Context ctx;
    private ArrayList<TvModel> tvModels;

    public ArrayList<TvModel> getTvModels() {
        return tvModels;
    }

    public void setTvModels(ArrayList<TvModel> tvModels) {
        this.tvModels = tvModels;
    }

    public TvRecyclerAdapter(Context context){
        this.ctx = context;
    }

    private View.OnClickListener clkListener;

    public void setOnItemClickListenerCustom(View.OnClickListener itemClickListener){
        this.clkListener = itemClickListener;
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View root = LayoutInflater.from(ctx).inflate(R.layout.recycler_list_item,viewGroup,false);
        return new TvViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder tvViewHolder, int i) {
        tvViewHolder.binding(i);
    }

    @Override
    public int getItemCount() {
        return tvModels.size();
    }

    public class TvViewHolder extends RecyclerView.ViewHolder {

        private TextView judulView;
        private ImageView posterView;

        public TvViewHolder(@NonNull View itemView) {
            super(itemView);

            judulView = itemView.findViewById(R.id.judul_item);
            posterView = itemView.findViewById(R.id.poster_item);

            itemView.setTag(this);
            itemView.setOnClickListener(clkListener);
        }

        public void binding(int position){
            judulView.setText(getTvModels().get(position).getJudulTv());
            Glide.with(ctx)
                    .load(getTvModels().get(position).getPosterTv())
                    .into(posterView);
        }
    }
}
