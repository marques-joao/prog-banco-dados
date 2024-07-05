package fatec.progbd.pizzaria.service;

import fatec.progbd.pizzaria.domain.entity.Entrega;
import fatec.progbd.pizzaria.domain.entity.ItemPedido;
import fatec.progbd.pizzaria.domain.entity.Pedido;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoService {

    Void adicionarPedido(Long clienteId, Pedido pedido);

    List<Pedido> listarPedidos();

    Pedido atualizarPedido(Long clienteId, Pedido pedidoAtualizado);

    void removerPedido(Long pedidoId);

    BigDecimal calcularTotal(Long pedidoId);

    String verificarStatusEntrega(Long pedidoId);

}