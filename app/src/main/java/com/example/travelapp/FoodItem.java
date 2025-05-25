package com.example.travelapp;

public class FoodItem {
    private String imageUrl;
    private String title;
    private String rating;

    public FoodItem(String imageUrl, String title, String rating) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }
}