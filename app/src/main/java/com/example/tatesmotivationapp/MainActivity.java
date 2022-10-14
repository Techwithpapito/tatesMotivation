 package com.example.tatesmotivationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

 public class MainActivity extends AppCompatActivity {

    private ImageButton andrew;
    private ImageButton tristan;
    private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Choose your Hero!");

        andrew = findViewById(R.id.andrew);
        tristan = findViewById(R.id.talis);

        andrew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(v, R.raw.andrew_saying);
            }
        });


        tristan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(v,R.raw.talis);
            }
        });

    }
    public void play(View v, int nameMusic){
        if (player == null){
            player = MediaPlayer.create(this,nameMusic);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

     @Override
     protected void onStop() {
         super.onStop();
         stopPlayer();
     }
 }