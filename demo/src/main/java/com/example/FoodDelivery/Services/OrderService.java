package com.example.FoodDelivery.Services;
import com.example.FoodDelivery.Entities.*;

public class OrderService {
    //after the order is finalised the control comes here
    // handles tracking order(loc,status) cancellation payment upon delivery
    public void updateStatus(Order o,OrderStatus status){
        o.updateStatus(status);
    }
    public OrderStatus viewStatus(Order o){
        return o.getOrderStatus();
    }
    public void CreditCardPayment(Order o){
        Payment payment=new CreditCardPayment(o.getPrice(),o.getCust(),o.getRest());
        payment.processPayment();
    }
    public void upiPayment(Order o,String upiId){
        Payment payment=new UPIPayment(o.getPrice(),o.getCust(),o.getRest(),upiId);
        payment.processPayment();
    }
}
