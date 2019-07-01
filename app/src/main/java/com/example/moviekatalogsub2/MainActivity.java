package com.example.moviekatalogsub2;

import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;

import com.example.moviekatalogsub2.adapter.FragAdapter;
import com.example.moviekatalogsub2.fragment.MovieFragment;
import com.example.moviekatalogsub2.fragment.TvFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ViewPager viewPager = findViewById(R.id.view_pager);
        setupVP(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.movie));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tv));
        tabLayout.setupWithViewPager(viewPager);

    }


    private void setupVP(ViewPager vp){

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager());
        adapter.addFragment(new MovieFragment(), getResources().getString(R.string.movie));
        adapter.addFragment(new TvFragment(), getResources().getString(R.string.tv));

        vp.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_setting){
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
