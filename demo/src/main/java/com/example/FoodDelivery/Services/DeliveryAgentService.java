package com.example.FoodDelivery.Services;
import java.util.*;
import com.example.FoodDelivery.Entities.*;
import com.example.FoodDelivery.Repository.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryAgentService {
    @Autowired
    private AgentRepo agentRepo;

    public void registerAgent(String id,Location loc,boolean isAval){
        DeliveryAgent agent=new DeliveryAgent(loc,isAval);
        agentRepo.save(agent);
    }
    //for an order we are tasked to find the most suitable delivery partner
    public DeliveryAgent bestPartner(Location loc){
        double minDist=Integer.MAX_VALUE;
        List<DeliveryAgent> availableAgents=agentRepo.findByIsAvalTrue();
        DeliveryAgent suitableAgent=null;
        for(DeliveryAgent agent:availableAgents){
            double dist=loc.distance(agent.getLoc());
            if(dist<minDist){
                suitableAgent=agent;
                minDist=dist;
            }
        }
        return suitableAgent;
    }
}
