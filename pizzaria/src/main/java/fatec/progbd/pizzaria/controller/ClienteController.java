package fatec.progbd.pizzaria.controller;

import fatec.progbd.pizzaria.domain.request.ClienteRequest;
import fatec.progbd.pizzaria.domain.response.ClienteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface ClienteController {

    @PostMapping("/clientes")
    ResponseEntity<ClienteResponse> adicionarCliente(@RequestBody ClienteRequest clienteRequest);

}