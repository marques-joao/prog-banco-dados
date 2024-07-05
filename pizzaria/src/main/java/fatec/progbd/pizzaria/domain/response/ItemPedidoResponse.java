package fatec.progbd.pizzaria.domain.response;

import java.math.BigDecimal;

public record ItemPedidoResponse(
        String descricao,
        BigDecimal precoUnitario,
        int quantidade
) {}