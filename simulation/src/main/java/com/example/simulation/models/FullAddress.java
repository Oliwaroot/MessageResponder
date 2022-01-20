
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
    "neighborhood",
    "ZIP_code",
    "city",
    "complement",
    "street",
    "state"
})
@Generated("jsonschema2pojo")
public class FullAddress {

    @JsonProperty("neighborhood")
    private String neighborhood;
    @JsonProperty("ZIP_code")
    private String zIPCode;
    @JsonProperty("city")
    private String city;
    @JsonProperty("complement")
    private String complement;
    @JsonProperty("street")
    private String street;
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("neighborhood")
    public String getNeighborhood() {
        return neighborhood;
    }

    @JsonProperty("neighborhood")
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    @JsonProperty("ZIP_code")
    public String getZIPCode() {
        return zIPCode;
    }

    @JsonProperty("ZIP_code")
    public void setZIPCode(String zIPCode) {
        this.zIPCode = zIPCode;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("complement")
    public String getComplement() {
        return complement;
    }

    @JsonProperty("complement")
    public void setComplement(String complement) {
        this.complement = complement;
    }

    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
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
