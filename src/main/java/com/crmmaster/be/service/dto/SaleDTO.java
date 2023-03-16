package com.crmmaster.be.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.crmmaster.be.domain.Sale} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SaleDTO implements Serializable {

    private String id;

    private Integer quantity;

    private Float price;

    private Integer tax;

    private Float discount;

    private ProductDTO product;

    private InvoiceDTO invoice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public InvoiceDTO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDTO invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SaleDTO)) {
            return false;
        }

        SaleDTO saleDTO = (SaleDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, saleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SaleDTO{" +
            "id='" + getId() + "'" +
            ", quantity=" + getQuantity() +
            ", price=" + getPrice() +
            ", tax=" + getTax() +
            ", discount=" + getDiscount() +
            ", product=" + getProduct() +
            ", invoice=" + getInvoice() +
            "}";
    }
}
