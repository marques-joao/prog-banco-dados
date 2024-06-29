package fatec.progbd.pizzaria.service.impl;

import fatec.progbd.pizzaria.entity.Entrega;
import fatec.progbd.pizzaria.entity.StatusEntrega;
import fatec.progbd.pizzaria.repository.EntregaRepository;
import fatec.progbd.pizzaria.repository.PedidoRepository;
import fatec.progbd.pizzaria.service.EntregaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntregaServiceImpl implements EntregaService {

    private final EntregaRepository entregaRepository;
    private final PedidoRepository pedidoRepository;

    @Override
    public void adicionarEntrega(Entrega entrega) {
        entregaRepository.save(entrega);
    }

    @Override
    public void removerEntrega(Long id) {
        entregaRepository.deleteById(id);
    }

    @Override
    public void atualizarEntrega(Entrega entrega) {
        entregaRepository.save(entrega);
    }

    @Override
    public List<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    @Override
    public void confirmarRecebimento(Long entregaId) {
        Entrega entrega = entregaRepository.findById(entregaId).orElseThrow(() -> new IllegalArgumentException("Entrega não encontrada."));
        entrega.setStatusEntrega(StatusEntrega.RECEBIDO);
        entregaRepository.save(entrega);
    }

    @Override
    public boolean verificarPagamento(Long entregaId) {
        Entrega entrega = entregaRepository.findById(entregaId).orElseThrow(() -> new IllegalArgumentException("Entrega não encontrada."));
        return entrega.isPagamentoConfirmado();
    }

}