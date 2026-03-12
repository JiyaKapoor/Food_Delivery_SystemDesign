package com.example.FoodDelivery.Entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name="restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restId;
    private String name;
    @OneToMany(mappedBy = "rest", cascade = CascadeType.ALL)
    List<MenuItem> menu;
    @Embedded
    Location loc;
    public Restaurant() {

    }

    public Restaurant(String name, Location loc) {
        this.name = name;
        this.loc = loc;
    }

    public List<MenuItem> getMenu() {
        return this.menu;
    }

    public long getRestId() {
        return this.restId;
    }

    public Location getLoc() {
        return this.loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant other = (Restaurant) o;
        return restId.equals(other.restId);
    }

    @Override
    public int hashCode() {
        return restId.hashCode();
    }
}
