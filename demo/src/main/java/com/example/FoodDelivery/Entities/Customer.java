package com.example.FoodDelivery.Entities;

public class Customer{
     String id;
     String name;
     Location loc;
    public Customer(String id,String name,Location loc){
        this.id=id;
        this.name=name;
        this.loc=loc;
    }
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