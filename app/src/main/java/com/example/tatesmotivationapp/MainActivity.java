 package com.example.tatesmotivationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

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


         DataSource.heroes.add(new Hero("Andrew",R.drawable.andrewpic,R.raw.andrew_saying,"https://thecitesite.com/authors/andrew-tate/"));
         DataSource.heroes.add(new Hero("Tristan",R.drawable.talismanpic,R.raw.talis,"https://thecitesite.com/authors/tristan-tate/"));

         linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
         myRvAdapter = new MyRvAdapter(DataSource.heroes);
         rv.setLayoutManager(linearLayoutManager);
         rv.setAdapter(myRvAdapter);




    }
    private void getParentName(View v) {
         View view = (View) v.getParent();
        System.out.println("hode" + view.getId());
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