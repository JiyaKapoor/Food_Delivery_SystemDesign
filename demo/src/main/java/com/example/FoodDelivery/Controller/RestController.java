package com.example.FoodDelivery.Controller;

import com.example.FoodDelivery.Entities.MenuItem;
import com.example.FoodDelivery.Entities.Restaurant;
import com.example.FoodDelivery.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/restaurants")
public class RestController {
    @Autowired
    private RestaurantService restaurantService;
    @PostMapping("/register")
    public void registerRest(@RequestBody Restaurant rest){
        restaurantService.registerRest(rest.getName(),rest.getLoc());
    }
    @GetMapping("/all")
    public List<Restaurant> getAllRest(){
        return restaurantService.getAllRestaurants();
    }
    @GetMapping("/getRest/{id}")
    public List<MenuItem> getRestById(@PathVariable Long id){
        return restaurantService.getMenuById(id);
    }
    @PostMapping("/{id}/addItem")
    public void addMenuItem(@PathVariable Long id,@RequestBody MenuItem item){
        restaurantService.addMenuItem(id,item);
    }
}
