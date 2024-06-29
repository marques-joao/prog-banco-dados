package fatec.progbd.pizzaria.service;

import fatec.progbd.pizzaria.entity.Entrega;

import java.util.List;

public interface EntregaService {

    void adicionarEntrega(Entrega entrega);
    void removerEntrega(Long id);
    void atualizarEntrega(Entrega entrega);
    List<Entrega> listarEntregas();

    void confirmarRecebimento(Long entregaId);
    boolean verificarPagamento(Long entregaId);

}