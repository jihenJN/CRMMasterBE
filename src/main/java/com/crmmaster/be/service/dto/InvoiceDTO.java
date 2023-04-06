package com.crmmaster.be.service.dto;

import com.crmmaster.be.domain.enumeration.status;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.crmmaster.be.domain.Invoice} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class InvoiceDTO implements Serializable {

    private String id;

    @NotNull
    private String code;

    private ZonedDateTime date;

    private Double discount;

    private Integer tax;

    private Double total;

    private byte[] stamp;

    private String stampContentType;
    private String remarks;

    private status status;

    private ClientDTO client;
    
    private List<SaleDTO> sales;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public List<SaleDTO> getSales() {
		return sales;
	}

	public void setSales(List<SaleDTO> sales) {
		this.sales = sales;
	}

	public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public byte[] getStamp() {
        return stamp;
    }

    public void setStamp(byte[] stamp) {
        this.stamp = stamp;
    }

    public String getStampContentType() {
        return stampContentType;
    }

    public void setStampContentType(String stampContentType) {
        this.stampContentType = stampContentType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public status getStatus() {
        return status;
    }

    public void setStatus(status status) {
        this.status = status;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InvoiceDTO)) {
            return false;
        }

        InvoiceDTO invoiceDTO = (InvoiceDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, invoiceDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

	@Override
	public String toString() {
		return "InvoiceDTO [id=" + id + ", code=" + code + ", date=" + date + ", discount=" + discount + ", tax=" + tax
				+ ", total=" + total + ", stamp=" + Arrays.toString(stamp) + ", stampContentType=" + stampContentType
				+ ", remarks=" + remarks + ", status=" + status + ", client=" + client + ", sales=" + sales + "]";
	}
    
    

   
}
