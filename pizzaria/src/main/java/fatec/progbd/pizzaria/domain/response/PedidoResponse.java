package fatec.progbd.pizzaria.domain.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record PedidoResponse(
        LocalDate data,
        LocalTime hora,
        int quantidadeItens,
        BigDecimal valorTotal,
        ClienteResponse clienteResponse,
        EntregaResponse entregaResponse,
        List<ItemPedidoResponse> itensPedidoResponse
) {}