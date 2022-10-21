 package com.example.tatesmotivationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

 public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    LinearLayoutManager linearLayoutManager;
    MyRvAdapter myRvAdapter;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Choose your Hero!");
        rv = findViewById(R.id.horizontalRv);

         linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
         myRvAdapter = new MyRvAdapter(DataSource.heroes);
         rv.setLayoutManager(linearLayoutManager);
         rv.setAdapter(myRvAdapter);
    }


 }