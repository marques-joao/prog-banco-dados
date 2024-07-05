package fatec.progbd.pizzaria.service.impl;

import fatec.progbd.pizzaria.domain.entity.Entrega;
import fatec.progbd.pizzaria.domain.entity.ItemPedido;
import fatec.progbd.pizzaria.domain.entity.Pedido;
import fatec.progbd.pizzaria.repository.PedidoRepository;
import fatec.progbd.pizzaria.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public void adicionarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public void removerPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public void atualizarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public BigDecimal calcularTotal(List<ItemPedido> itens) {
        return itens.stream()
                .map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String verificarStatusEntrega(Entrega entrega) {
        return entrega.getStatusEntrega().name();
    }

}