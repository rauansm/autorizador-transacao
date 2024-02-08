package com.vrbeneficios.cartao.application.service;

import com.vrbeneficios.cartao.application.api.CartaoRequest;
import com.vrbeneficios.cartao.application.api.CartaoResponse;

public interface CartaoService {
    CartaoResponse criaCartao(String idCliente,CartaoRequest cartaoRequest);
}
