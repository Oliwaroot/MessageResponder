package com.example.simulation.services;

import com.example.simulation.models.DeliveryStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeliveryStatusService {
    public DeliveryStatus getDeliveryStatus(String id_sale){
        Map<String, String> map = new HashMap<String, String>();
        map.put("id_sale", id_sale);
        return WebClient.create()
                .post()
                .uri("https://logistics-api-dot-active-thunder-329100.rj.r.appspot.com/tracking")
                .header("authorization","teste")
                .bodyValue(map)
                .retrieve()
                .bodyToMono(DeliveryStatus.class)
                .block();
    }
}
