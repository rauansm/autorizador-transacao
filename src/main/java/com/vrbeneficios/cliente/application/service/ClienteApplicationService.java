package com.vrbeneficios.cliente.application.service;

import com.vrbeneficios.cliente.application.api.ClienteRequest;
import com.vrbeneficios.cliente.application.api.ClienteResponse;
import com.vrbeneficios.cliente.application.repository.ClienteRepository;
import com.vrbeneficios.cliente.dominio.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService{
    private final ClienteRepository clienteRepository;
    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteApplicationService - criaCliente");
        Cliente clienteNovo = clienteRepository.criaCliente(new Cliente(clienteRequest));
        log.info("[finaliza] ClienteApplicationService - criaCliente");
        return new ClienteResponse(clienteNovo);
    }
}
