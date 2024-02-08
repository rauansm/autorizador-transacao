package com.vrbeneficios.cliente.application.api;

import com.vrbeneficios.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI{
    private final ClienteService clienteService;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteController - criaCliente");
        ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
        log.info("[finaliza] ClienteController - criaCliente");
        return clienteCriado;
    }

    @Override
    public ClienteResponse buscaClientePeloId(String idCliente) {
        log.info("[inicia] ClienteController - buscaClientePeloId");
        ClienteResponse cliente = clienteService.buscaClientePorId(idCliente);
        log.info("[finaliza] ClienteController - buscaClientePeloId");
        return cliente;
    }
}
