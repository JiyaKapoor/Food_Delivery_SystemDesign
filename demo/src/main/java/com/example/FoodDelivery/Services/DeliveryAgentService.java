package com.example.FoodDelivery.Services;
import java.util.*;
import com.example.FoodDelivery.Entities.*;
import org.springframework.stereotype.Service;
@Service
public class DeliveryAgentService {
    HashMap<String, DeliveryAgent> agents=new HashMap<>();
    public void registerAgent(String id,Location loc,boolean isAval){
        DeliveryAgent agent=new DeliveryAgent(id,loc,isAval);
        agents.put(id,agent);
    }
    //for an order we are tasked to find the most suitable delivery partner
    public DeliveryAgent bestPartner(Location loc){
        double minDist=Integer.MAX_VALUE;
        DeliveryAgent suitableAgent=null;
        for(String id:agents.keySet()){
            if(agents.get(id).getAval()){
                if (loc.distance(agents.get(id).getLoc()) < minDist) {
                    minDist = loc.distance(agents.get(id).getLoc());
                    suitableAgent = agents.get(id);
                }
            }
        }
        return suitableAgent;
    }
}
