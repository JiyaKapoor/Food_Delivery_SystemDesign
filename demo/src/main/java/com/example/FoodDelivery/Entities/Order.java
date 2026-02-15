package com.example.FoodDelivery.Entities;

public class Order {
    String orderId;
    Customer cust;
    Restaurant rest;
    OrderStatus orderstatus=OrderStatus.PREPARING;
    DeliveryAgent agent;
    double price;
    public Order(Customer cust,Restaurant rest,double price,DeliveryAgent agent){
        this.cust=cust;
        this.rest=rest;
        this.price=price;
        this.agent=agent;
    }
    //a method to change the order status
    public void updateStatus(OrderStatus status){
        this.orderstatus=status;
    }
    public OrderStatus getOrderStatus(){
        return this.orderstatus;
    }
    public double getPrice(){
        return this.price;
    }
    public Customer getCust(){
        return this.cust;
    }

    public Restaurant getRest() {
        return this.rest;
    }
}
