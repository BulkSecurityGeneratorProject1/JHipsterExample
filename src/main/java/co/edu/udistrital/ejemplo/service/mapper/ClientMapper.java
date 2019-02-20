package co.edu.udistrital.ejemplo.service.mapper;

import co.edu.udistrital.ejemplo.domain.*;
import co.edu.udistrital.ejemplo.service.dto.ClientDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Client and its DTO ClientDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {


    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "telephones", ignore = true)
    @Mapping(target = "invoices", ignore = true)
    Client toEntity(ClientDTO clientDTO);

    default Client fromId(Long id) {
        if (id == null) {
            return null;
        }
        Client client = new Client();
        client.setId(id);
        return client;
    }
}
