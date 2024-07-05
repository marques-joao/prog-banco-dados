package fatec.progbd.pizzaria.domain.response;

import fatec.progbd.pizzaria.domain.enums.StatusEntrega;

import java.time.LocalDate;
import java.time.LocalTime;

public record EntregaResponse(
        LocalDate dataEntrega,
        LocalTime horaEntrega,
        String tipoPagamento,
        String codigoDeEntrega,
        String enderecoEntrega,
        StatusEntrega statusEntrega,
        boolean pagamentoConfirmado
) {}