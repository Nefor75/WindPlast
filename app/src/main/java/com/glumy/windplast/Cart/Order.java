package com.glumy.windplast.Cart;

import android.widget.ImageView;

import java.io.Serializable;

public class Order implements Serializable {

    private String name;
    private int imageTop;
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
    private int cost;

    public Order(String name, String width_product, String height_product, String amount, String profile, String profile2part, String furniture,
                 String quantity_glasses, String glass, String manufacturer_sill, String manufacturer_weathering, String mounting, String delivery, int cost) {

        this.name = name;
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
}
