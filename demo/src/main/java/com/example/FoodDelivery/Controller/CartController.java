package com.example.FoodDelivery.Controller;

import com.example.FoodDelivery.DTO.CartReq;
import com.example.FoodDelivery.DTO.OrderReq;
import com.example.FoodDelivery.Entities.Customer;
import com.example.FoodDelivery.Entities.MenuItem;
import com.example.FoodDelivery.Entities.Order;
import com.example.FoodDelivery.Entities.Restaurant;
import com.example.FoodDelivery.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/add")
    public void addToCart(@RequestBody CartReq request){
        Customer cust=request.getCust();
        MenuItem item=request.getItem();
        int qty= request.getQty();
        cartService.addToCart(cust,item,qty);
    }
    //finalising the cart to place order
    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody OrderReq req){
        Customer cust=req.getCust();
        Restaurant rest=req.getRest();
        return cartService.placeOrder(cust,rest);
    }

}
