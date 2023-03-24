package com.crmmaster.be.domain;

import com.crmmaster.be.domain.enumeration.status;
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

    @NotNull
    @Field("code")
    private String code;

    @Field("date")
    private ZonedDateTime date;

    @Field("discount")
    private Double discount;

    @Field("tax")
    private Integer tax;

    @Field("total")
    private Double total;

    @Field("stamp")
    private byte[] stamp;

    @Field("stamp_content_type")
    private String stampContentType;

    @Field("remarks")
    private String remarks;

    @Field("status")
    private status status;

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

    public Integer getTax() {
        return this.tax;
    }

    public Invoice tax(Integer tax) {
        this.setTax(tax);
        return this;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
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

    public byte[] getStamp() {
        return this.stamp;
    }

    public Invoice stamp(byte[] stamp) {
        this.setStamp(stamp);
        return this;
    }

    public void setStamp(byte[] stamp) {
        this.stamp = stamp;
    }

    public String getStampContentType() {
        return this.stampContentType;
    }

    public Invoice stampContentType(String stampContentType) {
        this.stampContentType = stampContentType;
        return this;
    }

    public void setStampContentType(String stampContentType) {
        this.stampContentType = stampContentType;
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

    public status getStatus() {
        return this.status;
    }

    public Invoice status(status status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(status status) {
        this.status = status;
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
            ", code='" + getCode() + "'" +
            ", date='" + getDate() + "'" +
            ", discount=" + getDiscount() +
            ", tax=" + getTax() +
            ", total=" + getTotal() +
            ", stamp='" + getStamp() + "'" +
            ", stampContentType='" + getStampContentType() + "'" +
            ", remarks='" + getRemarks() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
