package com.example.FoodDelivery.Entities;

import jakarta.persistence.*;

import java.awt.*;

@Entity
@Table(name="menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="restId")
    private Restaurant rest;
    private String name;
    private double price;
    private boolean isAval;
    public MenuItem(){

    }
    public MenuItem(Restaurant rest,String name,double price,boolean isAval){
        this.rest=rest;
        this.name=name;
        this.price=price;
        this.isAval=isAval;
    }
    public double getPrice(){
        return this.price;
    }
    public Restaurant getRestaurant(){
        return this.rest;
    }
    public void setRestaurant(Restaurant rest){
        this.rest=rest;
    }
}
