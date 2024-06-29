package fatec.progbd.pizzaria.service;

import fatec.progbd.pizzaria.entity.Entrega;
import fatec.progbd.pizzaria.entity.ItemPedido;
import fatec.progbd.pizzaria.entity.Pedido;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoService {

    void adicionarPedido(Pedido pedido);
    void removerPedido(Long id);
    void atualizarPedido(Pedido pedido);
    List<Pedido> listarPedidos();

    BigDecimal calcularTotal(List<ItemPedido> itens);
    String verificarStatusEntrega(Entrega entrega);
}