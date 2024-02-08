package com.vrbeneficios.cliente.infra;

import com.vrbeneficios.cliente.application.repository.ClienteRepository;
import com.vrbeneficios.cliente.dominio.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPA clienteSpringDataJPA;
    @Override
    public Cliente criaCliente(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - criaCliente");
        try {
            clienteSpringDataJPA.save(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("sada");}
        log.info("[finaliza] ClienteInfraRepository - criaCliente");
        return cliente;
    }

    @Override
    public Cliente buscaClientePorId(String idCliente) {
        log.info("[inicia] ClienteInfraRepository - buscaClientePorId");
        Optional<Cliente> cliente = clienteSpringDataJPA.findById(idCliente);
        log.info("[finaliza] ClienteInfraRepository - buscaClientePorId");
        return cliente.orElseThrow();
    }
}
