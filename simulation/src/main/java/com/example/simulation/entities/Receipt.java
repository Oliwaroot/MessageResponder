package com.example.simulation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @Column(name = "merchant_id")
    private int merchant_id;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "status")
    private String status;
    @Column(name = "description")
    private String description;
    @Column(name = "value")
    private float value;

    public Receipt(int merchant_id, String created_at, String status, String description, float value) {
        this.merchant_id = merchant_id;
        this.created_at = created_at;
        this.status = status;
        this.description = description;
        this.value = value;
    }

    public Receipt() {
    }

    public int getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(int merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "merchant_id=" + merchant_id +
                ", created_at='" + created_at + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }
}
