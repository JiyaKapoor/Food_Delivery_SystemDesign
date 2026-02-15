package com.example.FoodDelivery.Entities;

public class Location {
    double x;
    double y;
    public Location(double x,double y){
        this.x=x;
        this.y=y;
    }
    public double distance(Location loc){
        return Math.abs(this.x-loc.x)+Math.abs(this.y-loc.y);
    }
}
