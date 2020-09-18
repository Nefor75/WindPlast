package com.glumy.windplast.Cart;


import java.io.Serializable;

public class Storage implements Serializable {

    private int image;
    private int number;
    private String name;
    private String address;
    private String comment;
    private String date;
    private int cost;

    public Storage(int image, int number, String name, String address, String comment, String date, int cost) {
        this.number = number;
        this.image = image;
        this.name = name;
        this.address = address;
        this.comment = comment;
        this.date = date;
        this.cost = cost;
    }

    public int getImage() {
        return image;
    }

    public int getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public int getCost() {
        return cost;
    }


}
