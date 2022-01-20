package com.example.simulation.services;

import com.example.simulation.models.ConversationList;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ConversationListService {
    public ConversationList getConversationList(){
        return WebClient.create()
                .post()
                .uri("https://chats-api-dot-active-thunder-329100.rj.r.appspot.com/conversations")
                .header("authorization","teste")
                .retrieve()
                .bodyToMono(ConversationList.class)
                .block();
    }
}
