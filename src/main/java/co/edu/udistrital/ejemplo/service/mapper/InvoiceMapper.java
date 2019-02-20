package co.edu.udistrital.ejemplo.service.mapper;

import co.edu.udistrital.ejemplo.domain.*;
import co.edu.udistrital.ejemplo.service.dto.InvoiceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Invoice and its DTO InvoiceDTO.
 */
@Mapper(componentModel = "spring", uses = {ClientMapper.class, DiscountMapper.class})
public interface InvoiceMapper extends EntityMapper<InvoiceDTO, Invoice> {

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "discount.id", target = "discountId")
    InvoiceDTO toDto(Invoice invoice);

    @Mapping(source = "clientId", target = "client")
    @Mapping(source = "discountId", target = "discount")
    Invoice toEntity(InvoiceDTO invoiceDTO);

    default Invoice fromId(Long id) {
        if (id == null) {
            return null;
        }
        Invoice invoice = new Invoice();
        invoice.setId(id);
        return invoice;
    }
}
