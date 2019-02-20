package co.edu.udistrital.ejemplo.service.mapper;

import co.edu.udistrital.ejemplo.domain.*;
import co.edu.udistrital.ejemplo.service.dto.DiscountDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Discount and its DTO DiscountDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DiscountMapper extends EntityMapper<DiscountDTO, Discount> {



    default Discount fromId(Long id) {
        if (id == null) {
            return null;
        }
        Discount discount = new Discount();
        discount.setId(id);
        return discount;
    }
}
