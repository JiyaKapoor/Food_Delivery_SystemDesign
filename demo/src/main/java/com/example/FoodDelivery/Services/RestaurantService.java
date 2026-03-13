package com.example.FoodDelivery.Services;

import com.example.FoodDelivery.Entities.*;
import com.example.FoodDelivery.Repository.MenuItemRepo;
import com.example.FoodDelivery.Repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private MenuItemRepo menuItemRepo;
    public void registerRest(String name,Location loc){
        Restaurant rest=new Restaurant(name,loc);
        restaurantRepo.save(rest);
    }
    //user should be able to browse restaurants and their menus
    public List<Restaurant> getAllRestaurants(){
        List<Restaurant> rest=restaurantRepo.findAll();
        return rest;
    }
    public List<MenuItem> getMenuById(Long id){
        Restaurant rest=restaurantRepo.getById(id);
        return rest.getMenu();
    }
    public void addMenuItem(Long id,MenuItem item){
        Restaurant rest=restaurantRepo.getById(id);
        item.setRestaurant(rest);
        menuItemRepo.save(item);
    }
}
