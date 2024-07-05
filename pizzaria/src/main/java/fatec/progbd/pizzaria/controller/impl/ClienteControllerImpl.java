package fatec.progbd.pizzaria.controller.impl;

import fatec.progbd.pizzaria.controller.ClienteController;
import fatec.progbd.pizzaria.domain.request.ClienteRequest;
import fatec.progbd.pizzaria.domain.response.ClienteResponse;
import fatec.progbd.pizzaria.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.ResponseEntity.ok;

@RequestMapping
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;

    @Override
    public ResponseEntity<ClienteResponse> adicionarCliente(ClienteRequest clienteRequest) {
        return ok(clienteService.adicionarCliente(clienteRequest));
    }
}