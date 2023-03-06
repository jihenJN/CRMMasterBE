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

    private InvoiceDTO invoice;

    private ProductDTO product;

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

    public InvoiceDTO getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDTO invoice) {
        this.invoice = invoice;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
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
            ", invoice=" + getInvoice() +
            ", product=" + getProduct() +
            "}";
    }
}
