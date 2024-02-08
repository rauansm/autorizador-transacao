package com.vrbeneficios.cartao.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class CartaoRequest {
    @NotBlank
    private String numeroCartao;
    @NotBlank
    @Size(min = 4, max = 4, message = "senha deve conter 4 digitos")
    private String senha;
}
