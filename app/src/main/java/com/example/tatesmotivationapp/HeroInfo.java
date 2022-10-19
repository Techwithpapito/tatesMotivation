package com.example.tatesmotivationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeroInfo extends AppCompatActivity {
    Hero heroe;
    ArrayList<String> heroQuotes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_info);
        int heroIndex = getIntent().getIntExtra("index", 0);
        heroe = DataSource.heroes.get(heroIndex);
        getSupportActionBar().setTitle(heroe.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        webScraper();
        int index = (int)(Math.random() * heroQuotes.size());
        TextView dayQuote = findViewById(R.id.dayQuote);
        dayQuote.setText(heroQuotes.get(index));


        Button moneyBtn = (Button) findViewById(R.id.moneyBtn);
        Button motivationBtn = (Button) findViewById(R.id.motivationBtn);
        Button dateBtn = (Button) findViewById(R.id.womanBtn);
        Button depressionBtn = (Button) findViewById(R.id.depressionBtn);
        TextView chosenTextView = (TextView) findViewById(R.id.chosenTextView);

        moneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> moneyKeywords = Arrays.asList("money","success","rich","poverty","");
                chosenTextView.setText(randomQuotePicker(moneyKeywords));
            }
        });
        motivationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> motivationKeyword = Arrays.asList("important","hope","control","lucky","fantasy","freedom","resist"
                ,"man","learn","happy","challenges","poverty","train","discipline","impossible");
                chosenTextView.setText(randomQuotePicker(motivationKeyword));
            }
        });
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> dateKeyword = Arrays.asList("woman","date","girl","girls","wife");
                chosenTextView.setText(randomQuotePicker(dateKeyword));
            }
        });
        depressionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> depressionKeyword  = Arrays.asList("happy","motivation","losers","normal","sad","trauma","failure","");
                chosenTextView.setText(randomQuotePicker(depressionKeyword));
            }
        });

    }
    private void webScraper() {
        int pagesNumbers = 3;

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1;i <=pagesNumbers; ++i){
                        String url = String.format(heroe.getUrl()+i);
                        Document doc = Jsoup.connect(url).get();
                        Elements quotesContainer = doc.select("div[class=quotecontainer]");

                        for (Element container : quotesContainer){
                            if (container.select(String.format(":contains(%s)",heroe.getName())).size() > 0){
                                heroQuotes.add(container.select("p[itemprop=text]").text());
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

 public String randomQuotePicker(List<String> keywords) {
     Boolean finish = false;
     int index = 0;
     while(finish == false) {
         index = (int) (Math.random() * heroQuotes.size());
         System.out.println(keywords);
         String regex = ".*(?:" + String.join("|", keywords) + ").*";
         if (heroQuotes.get(index).matches(regex)){
             return heroQuotes.get(index);
         }
     }
    return heroQuotes.get(index);
    }














}