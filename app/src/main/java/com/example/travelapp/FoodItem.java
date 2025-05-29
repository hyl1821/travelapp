package com.example.travelapp;

public class FoodItem {
    private int imageResId;
    private String title;
    private String rating;

    public FoodItem(int imageResId, String title, String rating) {
        this.imageResId = imageResId;
        this.title = title;
        this.rating = rating;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }
}