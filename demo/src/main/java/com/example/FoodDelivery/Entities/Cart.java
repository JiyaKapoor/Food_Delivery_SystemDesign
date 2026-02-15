package com.example.FoodDelivery.Entities;

import java.util.ArrayList;
import java.util.*;

public class Cart {
    Restaurant restaurant;
    Customer customer;
    HashMap<MenuItem,Integer> cartItems=new HashMap<>();
    public Cart(Restaurant restaurant,Customer customer){
        this.restaurant =restaurant;
        this.customer=customer;        
    }
    public void addItemToCart(MenuItem item,int qty){
       cartItems.put(item,qty);
    }
    public double computePrice(){
        // delivery charge+item charge
        double amt=0;
        for(MenuItem item:cartItems.keySet()){
            double price=item.price;
            int qty=cartItems.get(item);
            amt+=price*qty;
        }
        amt+=5*(restaurant.getLoc().distance(customer.loc));
        return amt;
    }
    //the customer may need to update (increment/decrement the capacity)
}
