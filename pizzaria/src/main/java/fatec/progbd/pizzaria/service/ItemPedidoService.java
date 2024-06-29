package fatec.progbd.pizzaria.service;

import fatec.progbd.pizzaria.entity.ItemPedido;

import java.util.List;

public interface ItemPedidoService {

    void adicionarItem(ItemPedido item);
    void removerItem(Long id);
    void atualizarItem(ItemPedido item);
    List<ItemPedido> listarItens();

}