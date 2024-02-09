package com.vrbeneficios.cartao.dominio;

import com.vrbeneficios.cartao.application.api.TransacaoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransacaoAprovadaEvent {
    private Cartao cartao;
    private TransacaoRequest transacaoRequest;
}
