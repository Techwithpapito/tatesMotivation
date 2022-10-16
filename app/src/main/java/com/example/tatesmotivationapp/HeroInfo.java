package com.example.tatesmotivationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class HeroInfo extends AppCompatActivity {
    Hero heroe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_info);
        int heroIndex = getIntent().getIntExtra("index",0);
        heroe = DataSource.heroes.get(heroIndex);
        getSupportActionBar().setTitle(heroe.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
}