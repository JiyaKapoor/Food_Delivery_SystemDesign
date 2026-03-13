package com.example.FoodDelivery.DTO;

public class OrderReq {
    private Long custId;
    private Long restId;
    public Long getCustId(){
        return this.custId;
    }
    public Long getRestId(){
        return this.restId;
    }


}
