package com.glumy.windplast.Cart;


public class Storage {

    private int image;
    private int numbercalc;
    private String name;
    private String address;
    private String comment;
    private String date;
    private String cost;


    public Storage(int image, int numbercalc, String name, String address, String comment, String date, String cost) {
        this.image = image;
        this.numbercalc = numbercalc;
        this.name = name;
        this.address = address;
        this.comment = comment;
        this.date = date;
        this.cost = cost;
    }

    public int getImage() {
        return image;
    }

    public int getNumbercalc() {
        return numbercalc;
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

    public String getCost() {
        return cost;
    }
}
