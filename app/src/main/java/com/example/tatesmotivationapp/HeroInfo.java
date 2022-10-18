package com.example.tatesmotivationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class HeroInfo extends AppCompatActivity {
    Hero heroe;
    ArrayList<String> heroQuotes = new ArrayList<String>();
    ArrayList<String> moneyQuotes = new ArrayList<String>();
    ArrayList<String> motivationQuotes = new ArrayList<String>();
    ArrayList<String> dateQuotes = new ArrayList<String>();
    ArrayList<String> depressionQuotes = new ArrayList<String>();
    ListView lista;

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
        lista = findViewById(R.id.quoteListView);
        TextView dayQuote = findViewById(R.id.dayQuote);
        dayQuote.setText(heroQuotes.get(index));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,heroQuotes);
        lista.setAdapter(adapter);
    }
    private void webScraper() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect(heroe.getUrl()).get();
                    Elements quotes = doc.select("p[itemprop]");
                    for (Element quote : quotes) {
//                        heroQuotes.add(quote.text());
                        addToArrayList(quote.text());



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

    public void addToArrayList(String quoteText) {
        ArrayList<String> money = { "michael"},


        if (quoteText.toLowerCase().indexOf(color_name.toLowerCase()) != -1) {
            return color_cocktails.get(color_name);
        }
//        return color_cocktails.get("white");
    }



}