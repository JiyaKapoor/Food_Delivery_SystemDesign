package com.example.FoodDelivery.Entities;

abstract public class Payment {
    private static long idCounter=0;
    long paymentId;
    double amount;
    PaymentStatus status=PaymentStatus.PENDING;
    Customer c;
    Restaurant rest;
    public Payment(double amount,Customer c,Restaurant r){
        this.paymentId=++idCounter;
        this.amount=amount;
        this.c=c;
        this.rest=r;
    }
    public abstract void processPayment();
    public abstract void refund();
}
