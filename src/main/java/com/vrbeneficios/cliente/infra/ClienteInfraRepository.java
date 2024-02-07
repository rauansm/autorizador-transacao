package com.vrbeneficios.cliente.infra;

import com.vrbeneficios.cliente.application.repository.ClienteRepository;
import com.vrbeneficios.cliente.dominio.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPA clienteSpringDataJPA;
    @Override
    public Cliente criaCliente(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - criaCliente");
        Cliente novoCliente = clienteSpringDataJPA.save(cliente);
        log.info("[finaliza] ClienteInfraRepository - criaCliente");
        return novoCliente;
    }
}
