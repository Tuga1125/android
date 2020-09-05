package com.example.onlinefoodorder.Model;

public class Order {
    private String quantity;
    private String price;
    private String date;
//    private String userid;
//    private String fooditemid;

    public Order(String quantity, String price, String date, String userid, String fooditemid) {
        this.quantity = quantity;
        this.price = price;
        this.date = date;
//        this.date = userid;
//        this.date = fooditemid;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public String getUserid() {
//        return userid;
//    }
//
//    public void setUserid(String userid) {
//        this.userid = userid;
//    }
//
//    public String getFooditemid() {
//        return fooditemid;
//    }
//
//    public void setFooditemid(String fooditemid) {
//        this.date = fooditemid;
//    }
}
