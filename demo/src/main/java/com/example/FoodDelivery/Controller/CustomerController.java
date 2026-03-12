package com.example.FoodDelivery.Controller;

import com.example.FoodDelivery.Entities.Customer;
import com.example.FoodDelivery.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("registerCustomer")
    public void registerCustomer(@RequestBody Customer customer){
        customerService.registerCustomer(customer);
    }
}
