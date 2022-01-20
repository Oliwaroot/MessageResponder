package com.example.simulation.entities;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @Column(name = "id_sale")
    private int id_sale;
    @Column(name = "merchant_id")
    private int merchant_id;
    @Column(name = "chip_id")
    private String chip_id;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "status")
    private String status;
    @Column(name = "description")
    private String description;

    public Sales() {
    }

    public Sales(int id_sale,
                 int merchant_id,
                 String chip_id,
                 String created_at,
                 String status,
                 String description) {
        this.id_sale = id_sale;
        this.merchant_id = merchant_id;
        this.chip_id = chip_id;
        this.created_at = created_at;
        this.status = status;
        this.description = description;
    }

    public int getId_sale() {
        return id_sale;
    }

    public void setId_sale(int id_sale) {
        this.id_sale = id_sale;
    }

    public int getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(int merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getChip_id() {
        return chip_id;
    }

    public void setChip_id(String chip_id) {
        this.chip_id = chip_id;
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

    @Override
    public String toString() {
        return "Sales{" +
                "id_sale=" + id_sale +
                ", merchant_id=" + merchant_id +
                ", chip_id=" + chip_id +
                ", created_at=" + created_at +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
