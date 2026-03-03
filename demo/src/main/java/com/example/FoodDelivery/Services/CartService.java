package com.example.FoodDelivery.Services;
import com.example.FoodDelivery.Entities.*;
import java.util.*;
public class CartService {
    DeliveryAgentService deliveryAgentService;
    public CartService(DeliveryAgentService deliveryAgentService){
        this.deliveryAgentService=deliveryAgentService;
    }
    //this service class allows users to modify their cart
    HashMap<Customer,HashMap<Restaurant,Cart>> customerCarts=new HashMap<>();
    public void addToCart(Customer cust,MenuItem item,int qty){
        //teh design allows users to maintain seperate carts for different restaurants
        if(!customerCarts.containsKey(cust)){
            HashMap<Restaurant,Cart> restCart=new HashMap<>();
            Cart cart=new Cart(item.getRestaurant(),cust);
            cart.addItemToCart(item,qty);
            restCart.put(item.getRestaurant(),cart);
            customerCarts.put(cust,restCart);
        }
        else{
            //we need to check if there is already a cart for thsi restaurant present
            HashMap<Restaurant,Cart> restCart=customerCarts.get(cust);
            if(restCart.containsKey(item.getRestaurant())){
                restCart.get(item.getRestaurant()).addItemToCart(item,qty);
            }
            else{
                Cart newCart=new Cart(item.getRestaurant(),cust);
                newCart.addItemToCart(item,qty);
                restCart.put(item.getRestaurant(),newCart);
            }
        }
    }
    public Order placeOrder(Customer customer,Restaurant restaurant){
        // we need to finalise the cart which we will be getting from the hashmap
        Cart customerCart=customerCarts.get(customer).get(restaurant);
        double price=customerCart.computePrice();
        //next up we are required to assign a delivery partner
        DeliveryAgent agent=deliveryAgentService.bestPartner(restaurant.getLoc());
        agent.toggleAval(false);
        Order order=new Order(customer,restaurant,price,agent);
        return order;
    }
}
