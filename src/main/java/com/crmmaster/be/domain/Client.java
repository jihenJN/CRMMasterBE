package com.crmmaster.be.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A Client.
 */
@Document(collection = "client")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("phone")
    private Integer phone;

    @Field("address")
    private String address;

    @Field("email")
    private String email;

    @Field("orders")
    private Integer orders;

    @Field("fidelity_card")
    private Boolean fidelityCard;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Client id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Client name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return this.phone;
    }

    public Client phone(Integer phone) {
        this.setPhone(phone);
        return this;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public Client address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public Client email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOrders() {
        return this.orders;
    }

    public Client orders(Integer orders) {
        this.setOrders(orders);
        return this;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Boolean getFidelityCard() {
        return this.fidelityCard;
    }

    public Client fidelityCard(Boolean fidelityCard) {
        this.setFidelityCard(fidelityCard);
        return this;
    }

    public void setFidelityCard(Boolean fidelityCard) {
        this.fidelityCard = fidelityCard;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }
        return id != null && id.equals(((Client) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Client{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", phone=" + getPhone() +
            ", address='" + getAddress() + "'" +
            ", email='" + getEmail() + "'" +
            ", orders=" + getOrders() +
            ", fidelityCard='" + getFidelityCard() + "'" +
            "}";
    }
}
