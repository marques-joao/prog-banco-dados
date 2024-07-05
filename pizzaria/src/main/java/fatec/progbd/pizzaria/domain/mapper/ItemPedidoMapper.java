package fatec.progbd.pizzaria.domain.mapper;

import fatec.progbd.pizzaria.domain.entity.ItemPedido;
import fatec.progbd.pizzaria.domain.request.ItemPedidoRequest;
import fatec.progbd.pizzaria.domain.response.ItemPedidoResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ItemPedidoMapper {

    ItemPedido map(ItemPedidoRequest source);

    ItemPedidoResponse map(ItemPedido source);

}