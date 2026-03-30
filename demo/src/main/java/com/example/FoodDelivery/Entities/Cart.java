package com.example.FoodDelivery.Entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.*;
@Entity
@Table(name="carts")
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name="rest_id")
    Restaurant restaurant;
    @ManyToOne
    @JoinColumn(name="cust_id")
    Customer customer;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    List<CartItem> cartItems=new ArrayList<>();
    public Cart(){

    }
    public Cart(Restaurant restaurant,Customer customer){
        this.restaurant =restaurant;
        this.customer=customer;        
    }
    public void addItemToCart(MenuItem item,int qty){
        CartItem cartItem=new CartItem(item,qty,this);
        cartItems.add(cartItem);
    }
    public double computePrice(){
        // delivery charge+item charge
        double amt=0;
        for(CartItem item:cartItems){
            MenuItem menuItem=item.menuItem;
            int qty=item.qty;
            double price=menuItem.getPrice();
            amt+=price*qty;
        }
        amt+=5*(restaurant.getLoc().distance(customer.getLoc()));
        return amt;
    }
    //the customer may need to update (increment/decrement the capacity)
}
