package com.example.FoodDelivery.Services;
import com.example.FoodDelivery.Entities.*;
import com.example.FoodDelivery.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    //after the order is finalised the control comes here
    // handles tracking order(loc,status) cancellation payment upon delivery
    @Autowired
    OrderRepo orderRepo;
    public void updateStatus(Long id,OrderStatus status){
        Order order=orderRepo.findById(id).get();
        order.setStatus(status);
        orderRepo.save(order);
    }
    public OrderStatus viewStatus(Long id){
        Order o=orderRepo.findById(id).orElseThrow();
        return o.getOrderStatus();
    }
    public void CreditCardPayment(Long id){
        Order o=orderRepo.findById(id).orElseThrow();
        Payment payment=new CreditCardPayment(o.getPrice(),o.getCust(),o.getRest());
        payment.processPayment();
    }
    public void upiPayment(Long id,String upiId){
        Order o=orderRepo.findById(id).orElseThrow();
        Payment payment=new UPIPayment(o.getPrice(),o.getCust(),o.getRest(),upiId);
        payment.processPayment();
    }
}
