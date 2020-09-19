package com.example.onlinefoodorder.Model;

public class Item {
    private String foodname;
    private String description;
    private String quantity;
    private String price;

    public Item(String foodname, String description, String quantity, String price) {
        this.foodname = foodname;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
