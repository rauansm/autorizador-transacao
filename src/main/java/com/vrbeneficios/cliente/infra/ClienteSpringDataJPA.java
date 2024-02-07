package com.vrbeneficios.cliente.infra;

import com.vrbeneficios.cliente.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteSpringDataJPA extends JpaRepository<Cliente, String> {
}
