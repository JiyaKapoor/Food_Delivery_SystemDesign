package com.example.FoodDelivery.Services;

import com.example.FoodDelivery.Entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestaurantService {
    HashMap<String, Restaurant> map=new HashMap<>();
    public void registerRest(String id, String name,Location loc){
        Restaurant rest=new Restaurant(name,loc);
        map.put(id,rest);
    }
    //user should be able to browse restaurants and their menus
    public List<Restaurant> getAllRestaurants(){
        List<Restaurant> rest=new ArrayList<>();
        for(String id:map.keySet()){
            rest.add(map.get(id));
        }
        return rest;
    }
    public List<MenuItem> getMenuById(String id){
        for(String s:map.keySet()){
            if(s.equals(id)){
                return map.get(s).getMenu();
            }
        }
        return null;
    }


}
