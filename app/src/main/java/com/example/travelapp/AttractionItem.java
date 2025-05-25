package com.example.travelapp;

public class AttractionItem {
    private String imageUrl;
    private String title;
    private String location;

    public AttractionItem(String imageUrl, String title, String location) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }
}