package com.vrbeneficios.cartao.application.api;

import com.vrbeneficios.cartao.dominio.Cartao;
import lombok.Value;

@Value
public class CartaoResponse {

    private String numeroCartao;
    private String senha;

    public CartaoResponse(Cartao novoCartao) {
        this.numeroCartao = novoCartao.getNumeroCartao();
        this.senha = novoCartao.getSenha().replaceAll(".","*");
    }
}
