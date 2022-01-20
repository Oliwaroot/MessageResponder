package com.example.simulation.services;

import com.example.simulation.models.Chip;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChipService {
    public Chip getChipDetails(String chip_id){
        Map<String, String> map = new HashMap<String, String>();
        map.put("chip_id", chip_id);
        return WebClient.create()
                .post()
                .uri("https://telecom-api-dot-active-thunder-329100.rj.r.appspot.com/chip_status")
                .header("authorization","teste")
                .bodyValue(map)
                .retrieve()
                .bodyToMono(Chip.class)
                .block();
    }
}
