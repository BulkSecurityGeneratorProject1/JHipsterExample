package co.edu.udistrital.ejemplo.service.mapper;

import co.edu.udistrital.ejemplo.domain.*;
import co.edu.udistrital.ejemplo.service.dto.TelephoneDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Telephone and its DTO TelephoneDTO.
 */
@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface TelephoneMapper extends EntityMapper<TelephoneDTO, Telephone> {

    @Mapping(source = "client.id", target = "clientId")
    TelephoneDTO toDto(Telephone telephone);

    @Mapping(source = "clientId", target = "client")
    Telephone toEntity(TelephoneDTO telephoneDTO);

    default Telephone fromId(Long id) {
        if (id == null) {
            return null;
        }
        Telephone telephone = new Telephone();
        telephone.setId(id);
        return telephone;
    }
}
