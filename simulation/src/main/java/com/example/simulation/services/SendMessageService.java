package com.example.simulation.services;

import com.example.simulation.models.SendMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class SendMessageService {
    public SendMessage sendResponseMessage(Map<String, String> map){
        return WebClient.create()
                .post()
                .uri("https://chats-api-dot-active-thunder-329100.rj.r.appspot.com/send_message")
                .header("authorization","teste")
                .bodyValue(map)
                .retrieve()
                .bodyToMono(SendMessage.class)
                .block();
    }
}
