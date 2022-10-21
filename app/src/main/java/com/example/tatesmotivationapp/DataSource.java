package com.example.tatesmotivationapp;

import java.util.ArrayList;
import java.util.Arrays;

public class DataSource {
    public static ArrayList<Hero> heroes = new ArrayList<Hero>(
            Arrays.asList(
                        new Hero("Andrew",R.drawable.andrewpic,R.raw.andrew_saying,"https://thecitesite.com/authors/andrew-tate/page/"),
                        new Hero("Tristan",R.drawable.talismanpic,R.raw.tristan_saying,"https://thecitesite.com/authors/tristan-tate/page/")
            ));
}
