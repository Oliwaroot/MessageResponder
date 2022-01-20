package com.example.simulation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @Column(name = "transaction_id")
    private int transaction_id;
    @Column(name = "merchant_id")
    private int merchant_id;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "value")
    private float value;

    public Transactions() {
    }

    public Transactions(int transaction_id, int merchant_id, String created_at, float value) {
        this.transaction_id = transaction_id;
        this.merchant_id = merchant_id;
        this.created_at = created_at;
        this.value = value;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transaction_id=" + transaction_id +
                ", merchant_id=" + merchant_id +
                ", created_at='" + created_at + '\'' +
                ", value=" + value +
                '}';
    }
}
