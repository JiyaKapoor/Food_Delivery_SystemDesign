package com.example.FoodDelivery.Controller;

import com.example.FoodDelivery.DTO.CartReq;
import com.example.FoodDelivery.DTO.OrderReq;
import com.example.FoodDelivery.Entities.Customer;
import com.example.FoodDelivery.Entities.MenuItem;
import com.example.FoodDelivery.Entities.Order;
import com.example.FoodDelivery.Entities.Restaurant;
import com.example.FoodDelivery.Repository.CustomerRepo;
import com.example.FoodDelivery.Repository.MenuItemRepo;
import com.example.FoodDelivery.Repository.RestaurantRepo;
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
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private MenuItemRepo menuItemRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @PostMapping("/add")
    public void addToCart(@RequestBody CartReq request){
        Customer cust=customerRepo.getById(request.getCustId());
        MenuItem item=menuItemRepo.getById(request.getItemId());
        int qty= request.getQty();
        cartService.addToCart(cust,item,qty);
    }
    //finalising the cart to place order
    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody OrderReq req){
        Customer cust=customerRepo.getById(req.getCustId());
        Restaurant rest=restaurantRepo.getById(req.getRestId());
        return cartService.placeOrder(cust,rest);
    }
}
