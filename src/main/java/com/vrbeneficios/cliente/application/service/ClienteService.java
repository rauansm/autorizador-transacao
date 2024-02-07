package com.vrbeneficios.cliente.application.service;

import com.vrbeneficios.cliente.application.api.ClienteRequest;
import com.vrbeneficios.cliente.application.api.ClienteResponse;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);
}
