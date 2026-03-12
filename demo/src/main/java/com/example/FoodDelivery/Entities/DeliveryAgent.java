package com.example.FoodDelivery.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="delivery_agents")
public class DeliveryAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    Location loc;
    boolean isAval;
    public DeliveryAgent(){

    }
    public DeliveryAgent(Location loc, boolean isAval) {
        this.loc = loc;
        this.isAval = isAval;
    }

    public void toggleAval(boolean newAval) {
        this.isAval = newAval;
    }

    public Location getLoc() {
        return this.loc;
    }

    public boolean getAval() {
        return this.isAval;
    }
}
