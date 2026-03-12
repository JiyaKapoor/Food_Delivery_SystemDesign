package com.example.FoodDelivery.Repository;

import com.example.FoodDelivery.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
