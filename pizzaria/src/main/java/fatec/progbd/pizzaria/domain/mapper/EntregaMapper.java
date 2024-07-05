package fatec.progbd.pizzaria.domain.mapper;

import fatec.progbd.pizzaria.domain.entity.Entrega;
import fatec.progbd.pizzaria.domain.request.EntregaRequest;
import fatec.progbd.pizzaria.domain.response.EntregaResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface EntregaMapper {

    Entrega map(EntregaRequest source);

    EntregaResponse map(Entrega source);

}