package com.example.FoodDelivery.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Embedded
    private Location loc;
    public Customer() {}

    public Customer(String name, Location loc) {
        this.name = name;
        this.loc = loc;
    }

    // getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public Location getLoc() { return loc; }

    // setters
    public void setName(String name) { this.name = name; }
    public void setLoc(Location loc) { this.loc = loc; }

    // your equals and hashCode — updated to use Long id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer other = (Customer) o;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}