package com.example.FoodDelivery.Entities;


import jakarta.persistence.*;

@Entity
@Table(name="cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name="menu_item_id")
    MenuItem menuItem;
    int qty;
    public CartItem(){

    }
    public CartItem(MenuItem item,int qty){
        this.menuItem=item;
        this.qty=qty;
    }
}
