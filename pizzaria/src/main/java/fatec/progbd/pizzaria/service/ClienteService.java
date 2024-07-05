package fatec.progbd.pizzaria.service;

import fatec.progbd.pizzaria.domain.entity.Cliente;
import fatec.progbd.pizzaria.domain.entity.Pedido;
import fatec.progbd.pizzaria.domain.request.ClienteRequest;
import fatec.progbd.pizzaria.domain.response.ClienteResponse;

import java.util.List;

public interface ClienteService {

    ClienteResponse adicionarCliente(ClienteRequest clienteRequest);

    List<Cliente> listarClientes();

    Cliente atualizarCliente(Long clienteId, Cliente clienteAtualizado);

    void removerCliente(Long clienteId);

    void adicionarPedido(Long clienteId, Pedido pedido);

    List<Pedido> getPedidos(Long clienteId);

}