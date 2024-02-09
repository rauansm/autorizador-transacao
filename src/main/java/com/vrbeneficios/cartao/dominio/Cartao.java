package com.vrbeneficios.cartao.dominio;

import com.vrbeneficios.cartao.application.api.CartaoRequest;
import com.vrbeneficios.cartao.application.api.TransacaoRequest;
import com.vrbeneficios.cliente.dominio.Cliente;
import com.vrbeneficios.handler.APIException;
import com.vrbeneficios.handler.ProblemType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Cartao extends AbstractAggregateRoot<Cartao> {

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

    public Cartao(Cliente cliente, CartaoRequest cartaoRequest) {
        this.numeroCartao = cartaoRequest.getNumeroCartao();
        this.saldo = new BigDecimal(500);
        this.senha = cartaoRequest.getSenha();
        this.donoCartao = cliente;
    }

    public void validaTransacao(TransacaoRequest transacaoRequest) {
        validaSenha(transacaoRequest);
        if (this.saldo.compareTo(transacaoRequest.getValor()) >= 0) {
            this.saldo = this.saldo.subtract(transacaoRequest.getValor());
            registerEvent(new TransacaoAprovadaEvent(this,transacaoRequest ));
        } else {
            throw APIException.negocio("Saldo insuficiente", ProblemType.SALDO_INSUFICIENTE);
        }


    }

    private void validaSenha(TransacaoRequest transacaoRequest) {
        if (!this.senha.equals(transacaoRequest.getSenha())) {
            throw APIException.negocio("Senha incorreta", ProblemType.SENHA_INVALIDA);
        }
    }
}
