package com.example.FoodDelivery.Repository;

import com.example.FoodDelivery.Entities.Cart;
import com.example.FoodDelivery.Entities.Customer;
import com.example.FoodDelivery.Entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart,Long> {

    boolean existsByCustomerAndRestaurant(Customer cust, Restaurant restaurant);
    Optional<Cart> findByCustomerAndRestaurant(Customer cust, Restaurant restaurant);
}
