
package com.example.simulation.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conversation_id",
    "messages",
    "merchant_id",
    "subject"
})
@Generated("jsonschema2pojo")
public class Conversation {

    @JsonProperty("conversation_id")
    private String conversationId;
    @JsonProperty("messages")
    private List<Message> messages = null;
    @JsonProperty("merchant_id")
    private String merchantId;
    @JsonProperty("subject")
    private String subject;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("conversation_id")
    public String getConversationId() {
        return conversationId;
    }

    @JsonProperty("conversation_id")
    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    @JsonProperty("messages")
    public List<Message> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @JsonProperty("merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    @JsonProperty("merchant_id")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
