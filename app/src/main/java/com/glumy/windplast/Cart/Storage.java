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
    private int mounting;
    private int delivery;
    private String date;
    private int cost;

   public Storage (int number, int image, String name, String address, String comment, String sizes, String amount,
                   String square, String profile, String profile2part, String furniture, String quantity_glasses, String glass,
                   String manufacturer_sill, String manufacturer_weathering, int mounting, int delivery, int cost){
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

    public String getDate() {
        return date;
    }

    public int getCost() {
        return cost;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getProfile2part() {
        return profile2part;
    }

    public void setProfile2part(String profile2part) {
        this.profile2part = profile2part;
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public String getQuantity_glasses() {
        return quantity_glasses;
    }

    public void setQuantity_glasses(String quantity_glasses) {
        this.quantity_glasses = quantity_glasses;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getManufacturer_sill() {
        return manufacturer_sill;
    }

    public void setManufacturer_sill(String manufacturer_sill) {
        this.manufacturer_sill = manufacturer_sill;
    }

    public String getManufacturer_weathering() {
        return manufacturer_weathering;
    }

    public void setManufacturer_weathering(String manufacturer_weathering) {
        this.manufacturer_weathering = manufacturer_weathering;
    }

    public int getMounting() {
        return mounting;
    }

    public void setMounting(int mounting) {
        this.mounting = mounting;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }
}
