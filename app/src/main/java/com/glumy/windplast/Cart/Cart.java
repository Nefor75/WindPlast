package com.glumy.windplast.Cart;

import java.io.Serializable;

public class Cart implements Serializable {

    private int id,width,height,amount,price,image,name;

    public Cart() {
    }

    public Cart(int id, int image, int name, int width, int height, int amount, int price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.width = width;
        this.height = height;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
