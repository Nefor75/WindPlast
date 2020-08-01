package com.glumy.windplast.Cart;

import java.io.Serializable;

public class Cart implements Serializable {

    private int width, height, widthSill, lengthSill, widthWeathering, lengthWeathering, amount, price, image;
    private String name;
    public Cart() {
    }

    public Cart(int image, String name, int width, int height, int widthSill, int lengthSill, int widthWeathering, int lengthWeathering, int amount, int price) {

        this.image = image;
        this.name = name;
        this.width = width;
        this.height = height;
        this.widthSill = widthSill;
        this.lengthSill = lengthSill;
        this.widthWeathering = widthWeathering;
        this.lengthWeathering = lengthWeathering;
        this.amount = amount;
        this.price = price;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidthSill() {
        return widthSill;
    }

    public void setWidthSill(int widthSill) {
        this.widthSill = widthSill;
    }

    public int getLengthSill() {
        return lengthSill;
    }

    public void setLengthSill(int lengthSill) {
        this.lengthSill = lengthSill;
    }

    public int getWidthWeathering() {
        return widthWeathering;
    }

    public void setWidthWeathering(int widthWeathering) {
        this.widthWeathering = widthWeathering;
    }

    public int getLengthWeathering() {
        return lengthWeathering;
    }

    public void setLengthWeathering(int lengthWeathering) {
        this.lengthWeathering = lengthWeathering;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
