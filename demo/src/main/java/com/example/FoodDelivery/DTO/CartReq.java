package com.example.FoodDelivery.DTO;

import com.example.FoodDelivery.Entities.Customer;
import com.example.FoodDelivery.Entities.MenuItem;

public class CartReq {
    private Customer cust;
    private MenuItem item;
    private int qty;
    public Customer getCust(){return this.cust;}
    public MenuItem getItem(){
        return this.item;
    }
    public int getQty(){
        return this.qty;
    }

}
