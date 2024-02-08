package com.vrbeneficios.cartao.application.api;

import lombok.Value;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class CartaoRequest {
    @NotBlank(message = "número do cartão não pode estar em branco")
    @Size(min = 16, max = 16, message = "número do cartão deve conter 16 dígitos")
    private String numeroCartao;
    @NotBlank
    @Size(min = 4, max = 4, message = "senha deve conter 4 dígitos")
    private String senha;
}
