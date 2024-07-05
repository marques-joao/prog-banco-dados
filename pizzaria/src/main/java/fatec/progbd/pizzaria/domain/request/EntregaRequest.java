package fatec.progbd.pizzaria.domain.request;

import fatec.progbd.pizzaria.domain.enums.StatusEntrega;

import java.time.LocalDate;
import java.time.LocalTime;

public record EntregaRequest(
        LocalDate dataEntrega,
        LocalTime horaEntrega,
        String tipoPagamento,
        String codigoDeEntrega,
        String enderecoEntrega,
        StatusEntrega statusEntrega,
        boolean pagamentoConfirmado
) {}