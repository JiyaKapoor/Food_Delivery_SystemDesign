package com.example.FoodDelivery.Services;
import com.example.FoodDelivery.Entities.*;
import com.example.FoodDelivery.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    public void registerCustomer(Customer c){
        customerRepo.save(c);
    }



}
