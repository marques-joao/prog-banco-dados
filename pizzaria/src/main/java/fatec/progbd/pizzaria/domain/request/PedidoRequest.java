package fatec.progbd.pizzaria.domain.request;

import fatec.progbd.pizzaria.domain.response.ClienteResponse;
import fatec.progbd.pizzaria.domain.response.EntregaResponse;
import fatec.progbd.pizzaria.domain.response.ItemPedidoResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record PedidoRequest(
        LocalDate data,
        LocalTime hora,
        int quantidadeItens,
        BigDecimal valorTotal,
        ClienteResponse clienteResponse,
        EntregaResponse entregaResponse,
        List<ItemPedidoResponse> itensPedidoResponse
) {}