package com.example.lovelychecker;

public class Chat {
    private int id;
    private String title;
    private String image;
    private double averageRating;
    private double price;
    private int countRatings;

    public Chat(int id, String title, String image, double averageRating, double price, int countRatings) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.averageRating = averageRating;
        this.price = price;
        this.countRatings = countRatings;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public double getPrice() {
        return price;
    }

    public int getCountRatings() {
        return countRatings;
    }
}

