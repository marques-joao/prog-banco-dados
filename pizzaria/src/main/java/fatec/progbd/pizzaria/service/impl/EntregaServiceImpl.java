package fatec.progbd.pizzaria.service.impl;

import fatec.progbd.pizzaria.domain.entity.Entrega;
import fatec.progbd.pizzaria.domain.entity.Pedido;
import fatec.progbd.pizzaria.domain.enums.StatusEntrega;
import fatec.progbd.pizzaria.domain.request.EntregaRequest;
import fatec.progbd.pizzaria.domain.response.EntregaResponse;
import fatec.progbd.pizzaria.repository.ClienteRepository;
import fatec.progbd.pizzaria.repository.EntregaRepository;
import fatec.progbd.pizzaria.repository.PedidoRepository;
import fatec.progbd.pizzaria.service.EntregaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntregaServiceImpl implements EntregaService {

    private final EntregaRepository entregaRepository;
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public Void adicionarEntrega(Long pedidoId, Entrega entrega) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        entrega.setPedido(pedido);
        entregaRepository.save(entrega);

        return null;
    }

    @Override
    public List<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    @Override
    public Entrega atualizarEntrega(Long entregaId, Entrega entregaAtualizada) {
        Entrega entrega = entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada."));

        entrega.setDataEntrega(entregaAtualizada.getDataEntrega());
        entrega.setHoraEntrega(entregaAtualizada.getHoraEntrega());
        entrega.setTipoPagamento(entregaAtualizada.getTipoPagamento());
        entrega.setCodigoDeEntrega(entregaAtualizada.getCodigoDeEntrega());
        entrega.setStatusEntrega(entregaAtualizada.getStatusEntrega());

        return entregaRepository.save(entrega);
    }

    @Override
    public void removerEntrega(Long entregaId) {
        entregaRepository.deleteById(entregaId);
    }

    @Override
    public void confirmarRecebimento(Long entregaId, String codigoDeEntrega) {
        Entrega entrega = entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada."));

        if(!entrega.getCodigoDeEntrega().equals(codigoDeEntrega)) {
            throw new RuntimeException("Código de entrega inválido");
        }

        entrega.setStatusEntrega(StatusEntrega.ENTREGUE);
        entregaRepository.save(entrega);
    }

    @Override
    public boolean verificarPagamento(Long entregaId) {
        Entrega entrega = entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada."));

        return entrega.isPagamentoConfirmado();
    }

}