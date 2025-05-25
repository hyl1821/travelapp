package com.example.travelapp;

public class RecommendItem {
    private String imageUrl;
    private String title;

    public RecommendItem(String imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }
}