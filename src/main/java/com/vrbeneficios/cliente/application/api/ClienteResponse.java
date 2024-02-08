package com.vrbeneficios.cliente.application.api;

import com.vrbeneficios.cliente.dominio.Cliente;
import com.vrbeneficios.cliente.dominio.Sexo;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ClienteResponse {

    private String idCliente;
    private String nome;
    private String email;
    private Sexo sexo;
    private LocalDateTime dataCadastro;

    public ClienteResponse(Cliente clienteNovo) {
        this.idCliente = clienteNovo.getIdCliente();
        this.nome = clienteNovo.getNome();
        this.email = clienteNovo.getEmail();
        this.sexo = clienteNovo.getSexo();
        this.dataCadastro = clienteNovo.getDataCadastro();
    }
}
