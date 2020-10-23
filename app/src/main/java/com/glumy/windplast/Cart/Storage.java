package com.glumy.windplast.Cart;


import java.io.Serializable;

public class Storage implements Serializable {

    private int image;
    private int number;
    private String name;
    private String address;
    private String comment;
    private String sizes;
    private String amount;
    private String square;
    private String profile;
    private String profile2part;
    private String furniture;
    private String quantity_glasses;
    private String glass;
    private String manufacturer_sill;
    private String manufacturer_weathering;
    private String mounting;
    private String delivery;
    private String date;
    private int cost;

   public Storage (int number, int image, String name, String address, String comment, String sizes, String amount,
                   String square, String profile, String profile2part, String furniture, String quantity_glasses, String glass,
                   String manufacturer_sill, String manufacturer_weathering, String mounting, String delivery, String date, int cost){
       this.number = number;
       this.image = image;
       this.name = name;
       this.address = address;
       this.comment = comment;
       this.sizes = sizes;
       this.amount = amount;
       this.square = square;
       this.profile = profile;
       this.profile2part = profile2part;
       this.furniture = furniture;
       this.quantity_glasses = quantity_glasses;
       this.manufacturer_sill = manufacturer_sill;
       this.manufacturer_weathering = manufacturer_weathering;
       this.glass = glass;
       this.mounting = mounting;
       this.delivery = delivery;
       this.cost = cost;
       this.date = date;
   }
    public Storage (int number, int image, String name, String address, String comment, String sizes, String amount,
                    String square, String profile, String profile2part, String furniture, String quantity_glasses, String glass,
                    String manufacturer_sill, String manufacturer_weathering, String mounting, String delivery, int cost){
        this.number = number;
        this.image = image;
        this.name = name;
        this.address = address;
        this.comment = comment;
        this.sizes = sizes;
        this.amount = amount;
        this.square = square;
        this.profile = profile;
        this.profile2part = profile2part;
        this.furniture = furniture;
        this.quantity_glasses = quantity_glasses;
        this.manufacturer_sill = manufacturer_sill;
        this.manufacturer_weathering = manufacturer_weathering;
        this.glass = glass;
        this.mounting = mounting;
        this.delivery = delivery;
        this.cost = cost;
        this.date = date;
    }

    public Storage(int image, int number, String name, String address, String comment, String date, int cost) {
        this.number = number;
        this.image = image;
        this.name = name;
        this.address = address;
        this.comment = comment;
        this.date = date;
        this.cost = cost;
    }

    public Storage(int image, String name, String address, String comment, String date, int cost) {
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

    public String getSizes() {
        return sizes;
    }

    public String getAmount() {
        return amount;
    }

    public String getSquare() {
        return square;
    }

    public String getProfile() {
        return profile;
    }

    public String getProfile2part() {
        return profile2part;
    }

    public String getFurniture() {
        return furniture;
    }

    public String getQuantity_glasses() {
        return quantity_glasses;
    }

    public String getGlass() {
        return glass;
    }

    public String getManufacturer_sill() {
        return manufacturer_sill;
    }

    public String getManufacturer_weathering() {
        return manufacturer_weathering;
    }

    public String getMounting() {
        return mounting;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getDate() {
        return date;
    }

    public int getCost() {
        return cost;
    }
}
