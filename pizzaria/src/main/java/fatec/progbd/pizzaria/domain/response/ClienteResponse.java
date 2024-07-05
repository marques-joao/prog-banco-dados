package fatec.progbd.pizzaria.domain.response;

public record ClienteResponse(
        String nome,
        String endereco,
        String telefone
) {}