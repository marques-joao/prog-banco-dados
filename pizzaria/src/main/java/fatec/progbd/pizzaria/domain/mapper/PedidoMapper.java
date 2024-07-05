package fatec.progbd.pizzaria.domain.mapper;

import fatec.progbd.pizzaria.domain.entity.Pedido;
import fatec.progbd.pizzaria.domain.request.PedidoRequest;
import fatec.progbd.pizzaria.domain.response.PedidoResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PedidoMapper {

    Pedido map(PedidoRequest source);

    PedidoResponse map(Pedido source);

}