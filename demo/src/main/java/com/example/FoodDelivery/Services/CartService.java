package com.example.FoodDelivery.Services;
import com.example.FoodDelivery.Entities.*;
import com.example.FoodDelivery.Repository.CartRepo;
import com.example.FoodDelivery.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class CartService {
    DeliveryAgentService deliveryAgentService;
    public CartService(DeliveryAgentService deliveryAgentService){
        this.deliveryAgentService=deliveryAgentService;
    }
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private OrderRepo orderRepo;
    //this service class allows users to modify their cart

    public void addToCart(Customer cust,MenuItem item,int qty){
        //the design allows users to maintain separate carts for different restaurants
        boolean cartExists=cartRepo.existsByCustomerAndRestaurant(cust,item.getRestaurant());
        if(!cartExists){
            Cart cart=new Cart(item.getRestaurant(),cust);
            cart.addItemToCart(item,qty);
            cartRepo.save(cart);
        }
        else{
            Cart existingCart=cartRepo.findByCustomerAndRestaurant(cust,item.getRestaurant()).orElseThrow(() -> new RuntimeException("Cart not found"));
            existingCart.addItemToCart(item,qty);
            cartRepo.save(existingCart);
        }
    }
    public Order placeOrder(Customer customer,Restaurant restaurant){
        // we need to finalise the cart which we will be getting from the hashmap
        Cart customerCart=cartRepo.findByCustomerAndRestaurant(customer,restaurant).orElseThrow(() -> new RuntimeException("Cart not found"));
        double price=customerCart.computePrice();
        //next up we are required to assign a delivery partner
        DeliveryAgent agent=deliveryAgentService.bestPartner(restaurant.getLoc());
        agent.toggleAval(false);
        Order order=new Order(customer,restaurant,price,agent);
        orderRepo.save(order);
        return order;
    }
}
