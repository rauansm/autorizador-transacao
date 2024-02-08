package com.vrbeneficios.cartao.dominio;

import com.vrbeneficios.cliente.dominio.Cliente;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Cartao {

    @Id
    @Column(columnDefinition = "bigint", name = "numero_cartao", updatable = false, unique = true, nullable = false)
    private String numeroCartao;
    @PositiveOrZero
    private BigDecimal saldo;
    private String senha;
    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente donoCartao;
    @CreationTimestamp
    private LocalDateTime dataCriacao;

}
