package com.crmmaster.be.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.crmmaster.be.domain.Client} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ClientDTO implements Serializable {

    private String id;

    private String name;

    private Integer phone;

    private String address;

    private String email;

    private Integer orders;

    private Boolean fidelityCard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Boolean getFidelityCard() {
        return fidelityCard;
    }

    public void setFidelityCard(Boolean fidelityCard) {
        this.fidelityCard = fidelityCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClientDTO)) {
            return false;
        }

        ClientDTO clientDTO = (ClientDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, clientDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClientDTO{" +
            "id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", phone=" + getPhone() +
            ", address='" + getAddress() + "'" +
            ", email='" + getEmail() + "'" +
            ", orders=" + getOrders() +
            ", fidelityCard='" + getFidelityCard() + "'" +
            "}";
    }
}
