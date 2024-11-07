package com.example.reciclerviewtest1;

public class Building {
    private String title;
    private String description;
    private int imageResourceId;

    public Building(String title, String description, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResourceId;
    }
}
