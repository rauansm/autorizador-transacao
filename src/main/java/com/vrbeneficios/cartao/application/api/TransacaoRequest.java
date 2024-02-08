package com.vrbeneficios.cartao.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Value
public class TransacaoRequest {

    @NotBlank(message = "Número do cartão não pode estar em branco")
    private String numeroCartao;
    @NotBlank
    @Size(min = 4, max = 4, message = "senha deve conter 4 digitos")
    private String senha;
    @Positive
    private BigDecimal valor;
}
