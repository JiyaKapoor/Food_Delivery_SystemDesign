package com.example.FoodDelivery.Entities;

import jakarta.persistence.*;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;
    @ManyToOne
    @JoinColumn(name="custId")
    Customer cust;
    @ManyToOne
    @JoinColumn(name="restId")
    Restaurant rest;
    OrderStatus orderstatus = OrderStatus.PREPARING;
    @OneToOne
    @JoinColumn(name="agentId")
    DeliveryAgent agent;
    double price;

    public Order(Customer cust, Restaurant rest, double price, DeliveryAgent agent) {
        this.cust = cust;
        this.rest = rest;
        this.price = price;
        this.agent = agent;
    }

    //a method to change the order status
    public void updateStatus(OrderStatus status) {
        this.orderstatus = status;
    }

    public OrderStatus getOrderStatus() {
        return this.orderstatus;
    }

    public double getPrice() {
        return this.price;
    }

    public Customer getCust() {
        return this.cust;
    }

    public Restaurant getRest() {
        return this.rest;
    }
}
