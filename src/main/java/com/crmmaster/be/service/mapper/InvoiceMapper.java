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
    @Mapping(target = "client", source = "client", qualifiedByName = "clientId")
    InvoiceDTO toDto(Invoice s);

    @Named("clientId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ClientDTO toDtoClientId(Client client);
}
