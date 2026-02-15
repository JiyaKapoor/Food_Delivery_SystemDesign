package com.example.FoodDelivery.Entities;

public class UPIPayment extends Payment{
    String upiID;
    public UPIPayment(double amount,Customer c,Restaurant r,String upiID){
        super(amount,c,r);
        this.upiID=upiID;
    }
    @Override
    public void processPayment(){
        this.status=PaymentStatus.SUCESS;
    }
    @Override
    public void refund(){
        this.status=PaymentStatus.REFUNDED;
    }

}
