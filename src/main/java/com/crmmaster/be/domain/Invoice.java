package com.crmmaster.be.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A Invoice.
 */
@Document(collection = "invoice")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("discount")
    private Double discount;

    @Field("tax")
    private Double tax;

    @Field("date")
    private ZonedDateTime date;

    @Field("total")
    private Double total;

    @Field("stamp")
    private Integer stamp;

    @Field("remarks")
    private String remarks;

    @NotNull
    @Field("code")
    private String code;

    @DBRef
    @Field("client")
    private Client client;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Invoice id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public Invoice discount(Double discount) {
        this.setDiscount(discount);
        return this;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTax() {
        return this.tax;
    }

    public Invoice tax(Double tax) {
        this.setTax(tax);
        return this;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public ZonedDateTime getDate() {
        return this.date;
    }

    public Invoice date(ZonedDateTime date) {
        this.setDate(date);
        return this;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public Double getTotal() {
        return this.total;
    }

    public Invoice total(Double total) {
        this.setTotal(total);
        return this;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getStamp() {
        return this.stamp;
    }

    public Invoice stamp(Integer stamp) {
        this.setStamp(stamp);
        return this;
    }

    public void setStamp(Integer stamp) {
        this.stamp = stamp;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public Invoice remarks(String remarks) {
        this.setRemarks(remarks);
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCode() {
        return this.code;
    }

    public Invoice code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Invoice client(Client client) {
        this.setClient(client);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Invoice)) {
            return false;
        }
        return id != null && id.equals(((Invoice) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Invoice{" +
            "id=" + getId() +
            ", discount=" + getDiscount() +
            ", tax=" + getTax() +
            ", date='" + getDate() + "'" +
            ", total=" + getTotal() +
            ", stamp=" + getStamp() +
            ", remarks='" + getRemarks() + "'" +
            ", code='" + getCode() + "'" +
            "}";
    }
}
