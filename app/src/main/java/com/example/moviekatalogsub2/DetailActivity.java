package com.example.moviekatalogsub2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviekatalogsub2.model.MovieModel;
import com.example.moviekatalogsub2.model.TvModel;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView judulDetail = findViewById(R.id.judul_detail);
        TextView jadwalDetail = findViewById(R.id.jadwal_detail);
        TextView rateDetail = findViewById(R.id.rate_detail);
        TextView descDetail = findViewById(R.id.desc_detail);
        ImageView imageDetail = findViewById(R.id.poster_detail);

        if(getIntent().getParcelableExtra("Extra").getClass().getSimpleName().equals("MovieModel")){

            MovieModel extra = getIntent().getParcelableExtra("Extra");
            judulDetail.setText(extra.getJudulMovie());
            jadwalDetail.setText(extra.getJadwalMovie());
            rateDetail.setText(extra.getRateMovie());
            descDetail.setText(extra.getDescMovie());
            Glide.with(this)
                    .load(extra.getPosterMovie())
                    .into(imageDetail);

        } else if (getIntent().getParcelableExtra("Extra").getClass().getSimpleName().equals("TvModel")){
            TvModel extra = getIntent().getParcelableExtra("Extra");
            judulDetail.setText(extra.getJudulTv());
            rateDetail.setText(extra.getRateTv());
            descDetail.setText(extra.getDescTv());
            Glide.with(this)
                    .load(extra.getPosterTv())
                    .into(imageDetail);
        }

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
