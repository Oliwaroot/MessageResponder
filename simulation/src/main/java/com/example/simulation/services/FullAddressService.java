package com.example.simulation.services;

import com.example.simulation.models.FullAddress;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class FullAddressService {
    public FullAddress getFullAddress(String zip_code){
        Map<String, String> map = new HashMap<String, String>();
        map.put("zip_code", zip_code);
        return WebClient.create()
                .post()
                .uri("https://logistics-api-dot-active-thunder-329100.rj.r.appspot.com/zip_code")
                .header("authorization","teste")
                .bodyValue(map)
                .retrieve()
                .bodyToMono(FullAddress.class)
                .block();
    }
}
