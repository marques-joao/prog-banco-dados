package fatec.progbd.pizzaria.domain.request;

import java.math.BigDecimal;

public record ItemPedidoRequest(
        String descricao,
        BigDecimal precoUnitario,
        int quantidade
) {}