package com.vrbeneficios.cliente.application.repository;

import com.vrbeneficios.cliente.dominio.Cliente;

public interface ClienteRepository {
    Cliente criaCliente(Cliente cliente);

    Cliente buscaClientePorId(String idCliente);
}
