package fatec.progbd.pizzaria.service.impl;

import fatec.progbd.pizzaria.domain.entity.Cliente;
import fatec.progbd.pizzaria.domain.entity.Pedido;
import fatec.progbd.pizzaria.domain.mapper.ClienteMapper;
import fatec.progbd.pizzaria.domain.request.ClienteRequest;
import fatec.progbd.pizzaria.domain.response.ClienteResponse;
import fatec.progbd.pizzaria.repository.ClienteRepository;
import fatec.progbd.pizzaria.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteResponse adicionarCliente(ClienteRequest clienteRequest) {
        return clienteMapper.map(clienteRepository.save(clienteMapper.map(clienteRequest)));
    }

    @Override
    public List<ClienteResponse> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream().map(clienteMapper::map).toList();
    }

    @Override
    public Cliente atualizarCliente(Long clienteId, Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEndereco(clienteAtualizado.getEndereco());
        cliente.setTelefone(clienteAtualizado.getTelefone());

        return clienteRepository.save(cliente);

    }

    @Override
    public void removerCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        clienteRepository.delete(cliente);
    }

    @Override
    public void adicionarPedido(Long clienteId, Pedido pedido) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));

        pedido.setCliente(cliente);
        cliente.getPedidos().add(pedido);

        clienteRepository.save(cliente);

    }

    @Override
    public List<Pedido> listarPedidos(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));

        return cliente.getPedidos();
    }

}