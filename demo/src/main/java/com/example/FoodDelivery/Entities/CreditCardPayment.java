package com.example.FoodDelivery.Entities;
public class CreditCardPayment extends Payment{
    private String cardNumber;
    private String CVV;
    public CreditCardPayment(double amount,Customer c,Restaurant r) {
        super(amount,c,r);
        this.cardNumber=cardNumber;
        this.CVV=CVV;
    }

    @Override
    public void processPayment() {
        this.status=PaymentStatus.SUCESS;
    }
    @Override
    public void refund(){
        this.status=PaymentStatus.REFUNDED;
    }
}
