package fatec.progbd.pizzaria.service;

import fatec.progbd.pizzaria.domain.entity.ItemPedido;
import fatec.progbd.pizzaria.domain.request.ItemPedidoRequest;
import fatec.progbd.pizzaria.domain.response.ItemPedidoResponse;

import java.util.List;

public interface ItemPedidoService {

    ItemPedidoResponse adicionarItemPedido(ItemPedidoRequest itemPedidoRequest);

    List<ItemPedido> listarItens();

    ItemPedido atualizarItens(Long itemPedidoId, ItemPedido itemPedidoAtualizado);

    void removerItemPedido(Long itemPedidoId);

}