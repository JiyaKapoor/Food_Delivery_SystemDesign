package com.example.FoodDelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.FoodDelivery.Entities.MenuItem;
public interface MenuItemRepo extends JpaRepository<MenuItem,Long> {
}
