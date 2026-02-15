package com.example.FoodDelivery.Services;
import com.example.FoodDelivery.Entities.*;

import java.util.HashMap;

public class CustomerService {
    HashMap<String,Customer> custMap=new HashMap<>();
    public void registerCustomer(String id,String name,Location loc){
        Customer newCust=new Customer(id,name,loc);
        custMap.put(id,newCust);
    }



}
