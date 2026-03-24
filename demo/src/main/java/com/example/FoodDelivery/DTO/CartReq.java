package com.example.FoodDelivery.DTO;
public class CartReq {
    private Long custId;
    private Long itemId;
    private int qty;
    public Long getCustId(){return this.custId;}
    public Long getItemId(){
        return this.itemId;
    }
    public int getQty(){
        return this.qty;
    }
    public void setCustId(Long custId){
        this.custId = custId;
    }

    public void setItemId(Long itemId){
        this.itemId = itemId;
    }

    public void setQty(int qty){
        this.qty = qty;
    }

}
