package fatec.progbd.pizzaria.service;

import fatec.progbd.pizzaria.domain.entity.Entrega;
import fatec.progbd.pizzaria.domain.entity.ItemPedido;
import fatec.progbd.pizzaria.domain.entity.Pedido;

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