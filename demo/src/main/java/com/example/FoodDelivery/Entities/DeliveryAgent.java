package com.example.FoodDelivery.Entities;

public class DeliveryAgent {
    String id;
    Location loc;
    boolean isAval;
    public DeliveryAgent(String id,Location loc,boolean isAval){
        this.id=id;
        this.loc=loc;
        this.isAval=isAval;
    }
    public void toggleAval(boolean newAval){
        this.isAval=newAval;
    }
    public Location getLoc(){
        return this.loc;
    }
    public boolean getAval(){
        return this.isAval;
    }
}
