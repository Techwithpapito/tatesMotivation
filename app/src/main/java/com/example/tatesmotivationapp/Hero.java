package com.example.tatesmotivationapp;

public class Hero {
    private String name;
    private Integer picture;
    private Integer voice;
    private String url;



    public  Hero(String name, Integer picture, Integer voice, String url) {
        this.name = name;
        this.picture = picture;
        this.voice = voice;
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPicture() {
        return picture;
    }

    public void setPicture(Integer picture) {
        this.picture = picture;
    }

    public Integer getVoice() {
        return voice;
    }

    public void setVoice(Integer voice) {
        this.voice = voice;
    }
}
