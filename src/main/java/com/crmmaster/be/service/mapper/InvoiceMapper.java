package com.crmmaster.be.service.mapper;

import com.crmmaster.be.domain.Client;
import com.crmmaster.be.domain.Invoice;
import com.crmmaster.be.service.dto.ClientDTO;
import com.crmmaster.be.service.dto.InvoiceDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Invoice} and its DTO {@link InvoiceDTO}.
 */
@Mapper(componentModel = "spring")
public interface InvoiceMapper extends EntityMapper<InvoiceDTO, Invoice> {
    @Mapping(target = "client", source = "client", qualifiedByName = "clientName")
    InvoiceDTO toDto(Invoice s);

    @Named("clientName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "email", source = "email")
    ClientDTO toDtoClientName(Client client);
}
