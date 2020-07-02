package com.glumy.windplast.Cart;

public class Storage {

    private int image;
    private String date;
    private String cost;


    public Storage(int image, String date, String cost) {
        this.image = image;
        this.date = date;
        this.cost = cost;
    }

    public int getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }

    public String getCost() {
        return cost;
    }
}
