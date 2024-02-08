package com.vrbeneficios.cliente.dominio;

import com.vrbeneficios.cliente.application.api.ClienteRequest;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Cliente {
    @Id
    @Column(columnDefinition = "VARCHAR(36)", name = "id_cliente", updatable = false, unique = true, nullable = false)
    private String idCliente;
    private String nome;
    @Column(unique = true)
    private String email;
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Cliente(ClienteRequest clienteRequest) {
        this.idCliente = UUID.randomUUID().toString();
        this.nome = clienteRequest.getNome();
        this.email = clienteRequest.getEmail();
        this.sexo = clienteRequest.getSexo();
    }
}
