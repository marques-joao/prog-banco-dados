package fatec.progbd.pizzaria.service.impl;

import fatec.progbd.pizzaria.domain.entity.Cliente;
import fatec.progbd.pizzaria.domain.entity.Entrega;
import fatec.progbd.pizzaria.domain.entity.ItemPedido;
import fatec.progbd.pizzaria.domain.entity.Pedido;
import fatec.progbd.pizzaria.domain.response.PedidoResponse;
import fatec.progbd.pizzaria.domain.util.CodigoEntregaGenerator;
import fatec.progbd.pizzaria.repository.ClienteRepository;
import fatec.progbd.pizzaria.repository.PedidoRepository;
import fatec.progbd.pizzaria.service.PedidoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public Void adicionarPedido(Long clienteId, Pedido pedido) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        pedido.setCliente(cliente);
        pedido.getEntrega().setCodigoDeEntrega(CodigoEntregaGenerator.generateCodigoEntrega());

        pedidoRepository.save(pedido);

        return null;
    }

    @Override
    public void removerPedido(Long pedidoId) {
        pedidoRepository.deleteById(pedidoId);
    }

    @Override
    public Pedido atualizarPedido(Long pedidoId, Pedido pedidoAtualizado) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        pedido.setData(pedidoAtualizado.getData());
        pedido.setHora(pedidoAtualizado.getHora());
        pedido.setQuantidadeItens(pedidoAtualizado.getQuantidadeItens());
        pedido.setValorTotal(pedidoAtualizado.getValorTotal());
        pedido.setCliente(pedidoAtualizado.getCliente());
        pedido.setEntrega(pedidoAtualizado.getEntrega());
        pedido.setItens(pedidoAtualizado.getItens());

        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public BigDecimal calcularTotal(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        return pedido.getItens().stream()
                .map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String verificarStatusEntrega(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        return pedido.getEntrega().getStatusEntrega().toString();
    }

}