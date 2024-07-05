package fatec.progbd.pizzaria.domain.request;

public record ClienteRequest(
        String nome,
        String endereco,
        String telefone
) {}