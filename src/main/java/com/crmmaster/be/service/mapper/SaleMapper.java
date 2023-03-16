package com.crmmaster.be.service.mapper;

import com.crmmaster.be.domain.Invoice;
import com.crmmaster.be.domain.Product;
import com.crmmaster.be.domain.Sale;
import com.crmmaster.be.service.dto.InvoiceDTO;
import com.crmmaster.be.service.dto.ProductDTO;
import com.crmmaster.be.service.dto.SaleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Sale} and its DTO {@link SaleDTO}.
 */
@Mapper(componentModel = "spring")
public interface SaleMapper extends EntityMapper<SaleDTO, Sale> {
    @Mapping(target = "product", source = "product", qualifiedByName = "productName")
    @Mapping(target = "invoice", source = "invoice", qualifiedByName = "invoiceId")
    SaleDTO toDto(Sale s);

    @Named("productName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ProductDTO toDtoProductName(Product product);

    @Named("invoiceId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    InvoiceDTO toDtoInvoiceId(Invoice invoice);
}
