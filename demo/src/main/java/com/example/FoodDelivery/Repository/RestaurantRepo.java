package com.example.FoodDelivery.Repository;

import com.example.FoodDelivery.Entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {

}
