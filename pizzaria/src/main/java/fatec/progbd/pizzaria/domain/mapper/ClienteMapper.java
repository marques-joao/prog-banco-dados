package fatec.progbd.pizzaria.domain.mapper;

import fatec.progbd.pizzaria.domain.entity.Cliente;
import fatec.progbd.pizzaria.domain.request.ClienteRequest;
import fatec.progbd.pizzaria.domain.response.ClienteResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ClienteMapper {

    Cliente map(ClienteRequest source);

    ClienteResponse map(Cliente source);

}