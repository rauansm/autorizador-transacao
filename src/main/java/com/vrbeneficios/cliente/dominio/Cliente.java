package com.vrbeneficios.cliente.dominio;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Cliente {

    @Id
    @Column(columnDefinition = "varchar", name = "id_cliente", updatable = false, unique = true, nullable = false)
    private UUID idCliente;
    private String nome;
    @Column(unique = true)
    private String email;
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

}
