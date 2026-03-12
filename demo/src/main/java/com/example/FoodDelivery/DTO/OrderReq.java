package com.example.FoodDelivery.DTO;

import com.example.FoodDelivery.Entities.Customer;
import com.example.FoodDelivery.Entities.Restaurant;

public class OrderReq {
    private Customer cust;
    private Restaurant rest;
    public Customer getCust(){
        return this.cust;
    }
    public Restaurant getRest(){
        return this.rest;
    }
}
