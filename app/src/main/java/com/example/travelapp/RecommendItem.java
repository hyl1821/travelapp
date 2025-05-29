package com.example.travelapp;

public class RecommendItem {
    private int imageResId;
    private String title;

    public RecommendItem(int imageResId, String title) {
        this.imageResId = imageResId;
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }
}