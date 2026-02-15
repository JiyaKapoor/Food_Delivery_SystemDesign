package com.example.FoodDelivery.Entities;

public class MenuItem {
    Restaurant rest;
    String name;
    double price;
    boolean isAval;
    public MenuItem(Restaurant rest,String name,double price,boolean isAval){
        this.rest=rest;
        this.name=name;
        this.price=price;
        this.isAval=isAval;
    }
    public Restaurant getRestaurant(){
        return this.rest;
    }
}
