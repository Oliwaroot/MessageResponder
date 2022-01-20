package com.example.simulation.services;

import com.example.simulation.models.Conversation;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConversationsService {

    public Conversation getConversation(String conversation_id){
        Map<String, String> map = new HashMap<String, String>();
        map.put("conversation_id", conversation_id);
        return WebClient.create()
                .post()
                .uri("https://chats-api-dot-active-thunder-329100.rj.r.appspot.com/conversation_info")
                .header("authorization","teste")
                .bodyValue(map)
                .retrieve()
                .bodyToMono(Conversation.class)
                .block();
    }
}
