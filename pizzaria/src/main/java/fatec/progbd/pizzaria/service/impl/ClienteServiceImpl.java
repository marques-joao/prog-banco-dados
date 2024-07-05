package fatec.progbd.pizzaria.service.impl;

import fatec.progbd.pizzaria.domain.entity.Cliente;
import fatec.progbd.pizzaria.domain.entity.Pedido;
import fatec.progbd.pizzaria.repository.ClienteRepository;
import fatec.progbd.pizzaria.repository.PedidoRepository;
import fatec.progbd.pizzaria.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;

    @Override
    public void adicionarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void removerCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void atualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void adicionarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }

}