package com.example.FoodDelivery.Controller;

import com.example.FoodDelivery.Entities.OrderStatus;
import com.example.FoodDelivery.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/checkStatus/{id}")
    public OrderStatus getOrderStatus(@PathVariable Long id){
       return orderService.viewStatus(id);
    }
    @PostMapping("/updateStatus/{id}")
    public void updateStatus(@PathVariable Long id,@RequestBody OrderStatus status){
        orderService.updateStatus(id,status);
    }
    @PostMapping("/CCPayment/{id}")
    public void CCPayment(@PathVariable Long id){
        orderService.CreditCardPayment(id);
    }
    @PostMapping("/UPIPayment/{id}/{upiId}")
    public void UPIPayment(@PathVariable Long id,@PathVariable String upiId){
        orderService.upiPayment(id,upiId);
    }
}
