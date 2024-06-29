package fatec.progbd.pizzaria.service;

import fatec.progbd.pizzaria.entity.Cliente;
import fatec.progbd.pizzaria.entity.Pedido;

import java.util.List;

public interface ClienteService {

    void adicionarCliente(Cliente cliente);
    void removerCliente(Long id);
    void atualizarCliente(Cliente cliente);
    List<Cliente> listarClientes();

    void adicionarPedido(Pedido pedido);
    List<Pedido> getPedidos();

}