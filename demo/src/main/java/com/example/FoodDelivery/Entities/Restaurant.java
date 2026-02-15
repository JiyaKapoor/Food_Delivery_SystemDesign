package com.example.FoodDelivery.Entities;

import java.util.List;

public class Restaurant {
    String restId;
    String name;
    List<MenuItem> menu;
    Location loc;
    public Restaurant(String restId,String name,Location loc){
        this.restId=restId;
        this.name=name;
        this.loc=loc;
    }
    public List<MenuItem> getMenu(){
        return this.menu;
    }
    public String getRestId(){
        return this.restId;
    }
    public Location getLoc(){
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
