package com.example.FoodDelivery.Controller;

import com.example.FoodDelivery.Entities.DeliveryAgent;
import com.example.FoodDelivery.Entities.Location;
import com.example.FoodDelivery.Services.DeliveryAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    private DeliveryAgentService deliveryAgentService;
    @PostMapping("/registerAgent")
    public void  registerAgent(@RequestBody DeliveryAgent agent){
        deliveryAgentService.registerAgent(agent.getLoc(), agent.getAval());
    }
    @GetMapping("/bestPartner")
    public DeliveryAgent bestPartner(@RequestBody Location loc){
        return deliveryAgentService.bestPartner(loc);
    }
}
