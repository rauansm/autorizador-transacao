package com.vrbeneficios.cartao.application.repository;

import com.vrbeneficios.cartao.dominio.Cartao;

public interface CartaoRepository {
    Cartao salva(Cartao cartao);

    Cartao buscaCartaoPeloNumero(String numeroCartao);
}
