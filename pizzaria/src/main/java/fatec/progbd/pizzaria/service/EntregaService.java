package fatec.progbd.pizzaria.service;

import fatec.progbd.pizzaria.domain.entity.Entrega;
import fatec.progbd.pizzaria.domain.enums.StatusEntrega;
import fatec.progbd.pizzaria.domain.request.EntregaRequest;
import fatec.progbd.pizzaria.domain.response.EntregaResponse;

import java.util.List;

public interface EntregaService {

    Void adicionarEntrega(Long pedidoId, Entrega entrega);

    List<Entrega> listarEntregas();

    Entrega atualizarEntrega(Long entregaId, Entrega entregaAtualizada);

    void removerEntrega(Long entregaId);

    void confirmarRecebimento(Long entregaId, String codigoDeEntrega);

    boolean verificarPagamento(Long entregaId);

}