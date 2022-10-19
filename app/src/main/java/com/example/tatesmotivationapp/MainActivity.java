 package com.example.tatesmotivationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

 public class MainActivity extends AppCompatActivity {

    private MediaPlayer player;
    RecyclerView rv;
    LinearLayoutManager linearLayoutManager;
    MyRvAdapter myRvAdapter;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Choose your Hero!");
        rv = findViewById(R.id.horizontalRv);

        //Setting the data source
         DataSource.heroes.add(new Hero("Andrew",R.drawable.andrewpic,R.raw.andrew_saying,"https://thecitesite.com/authors/andrew-tate/page/"));
         DataSource.heroes.add(new Hero("Tristan",R.drawable.talismanpic,R.raw.tristan_saying,"https://thecitesite.com/authors/tristan-tate/page/"));

         linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
         myRvAdapter = new MyRvAdapter(DataSource.heroes);
         rv.setLayoutManager(linearLayoutManager);
         rv.setAdapter(myRvAdapter);

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