package com.glumy.windplast.Cart;

import android.widget.ImageView;

import java.io.Serializable;

public class Order implements Serializable {

    private int number;
    private String name;
    private int imageTop;
    private int image;
    private String sizes;
    private String square;
    private String address;
    private String comment;
    private String width_product;
    private String height_product;
    private String amount;
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

    public Order (int number, int image, String name, String address, String comment, String sizes, String amount,
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
    }

    public Order(String name, int imageTop, String width_product, String height_product, String amount, String profile, String profile2part,
                 String furniture, String quantity_glasses, String glass, String manufacturer_sill, String manufacturer_weathering,
                 String mounting, String delivery, int cost) {
        this.name = name;
        this.imageTop = imageTop;
        this.width_product = width_product;
        this.height_product = height_product;
        this.amount = amount;
        this.profile = profile;
        this.profile2part = profile2part;
        this.furniture = furniture;
        this.quantity_glasses = quantity_glasses;
        this.glass = glass;
        this.manufacturer_sill = manufacturer_sill;
        this.manufacturer_weathering = manufacturer_weathering;
        this.mounting = mounting;
        this.delivery = delivery;
        this.cost = cost;
    }
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getImage() {
        return image;
    }

    public String getSizes() {
        return sizes;
    }

    public String getSquare() {
        return square;
    }

    public String getDate() {
        return date;
    }

    public int getImageTop() {
        return imageTop;
    }

    public String getWidth_product() {
        return width_product;
    }

    public String getHeight_product() {
        return height_product;
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

    public String getAmount() {
        return amount;
    }

    public String getMounting() {
        return mounting;
    }

    public String getDelivery() {
        return delivery;
    }

    public int getCost() {
        return cost;
    }

    public String getAddress() {
        return address;
    }

    public String getComment() {
        return comment;
    }
}
