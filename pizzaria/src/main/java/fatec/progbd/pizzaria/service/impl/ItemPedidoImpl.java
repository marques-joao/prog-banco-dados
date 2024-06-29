package fatec.progbd.pizzaria.service.impl;

import fatec.progbd.pizzaria.entity.ItemPedido;
import fatec.progbd.pizzaria.repository.ItemPedidoRepository;
import fatec.progbd.pizzaria.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemPedidoImpl implements ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    @Override
    public void adicionarItem(ItemPedido item) {
        itemPedidoRepository.save(item);
    }

    @Override
    public void removerItem(Long id) {
        itemPedidoRepository.deleteById(id);
    }

    @Override
    public void atualizarItem(ItemPedido item) {
        itemPedidoRepository.save(item);
    }

    @Override
    public List<ItemPedido> listarItens() {
        return itemPedidoRepository.findAll();
    }

}