
package com.example.simulation.models;

import java.util.HashMap;
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
    "message",
    "sent",
    "description"
})
@Generated("jsonschema2pojo")
public class SendMessage {

    @JsonProperty("conversation_id")
    private String conversationId;
    @JsonProperty("message")
    private String message;
    @JsonProperty("sent")
    private String sent;
    @JsonProperty("description")
    private String description;
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

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("sent")
    public String getSent() {
        return sent;
    }

    @JsonProperty("sent")
    public void setSent(String sent) {
        this.sent = sent;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
