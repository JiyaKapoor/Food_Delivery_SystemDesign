package com.example.FoodDelivery.Repository;

import com.example.FoodDelivery.Entities.DeliveryAgent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentRepo extends JpaRepository<DeliveryAgent,Long> {
    List<DeliveryAgent> findByIsAvalTrue();
}
