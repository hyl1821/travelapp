package com.example.travelapp;

public class AttractionItem {
    private int imageResId;
    private String title;
    private String location;

    public AttractionItem(int imageResId, String title, String location) {
        this.imageResId = imageResId;
        this.title = title;
        this.location = location;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }
}