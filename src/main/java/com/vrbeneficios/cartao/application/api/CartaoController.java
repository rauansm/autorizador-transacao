package com.vrbeneficios.cartao.application.api;

import com.vrbeneficios.cartao.application.service.CartaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CartaoController implements CartaoAPI{
    private final CartaoService cartaoService;
    @Override
    public CartaoResponse criaCartao(String idCliente, CartaoRequest cartaoRequest) {
        log.info("[inicia] CartaoController - criaCartao");
        CartaoResponse cartaoCriado = cartaoService.criaCartao(idCliente, cartaoRequest);
        log.info("[finaliza] CartaoController - criaCartao");
        return cartaoCriado;
    }

    @Override
    public CartaoSaldoResponse consultaSaldoCartao(String numeroCartao) {
        log.info("[inicia] CartaoController - consultaSaldoCartao");
        CartaoSaldoResponse saldoCartao = cartaoService.consultaSaldoCartao(numeroCartao);
        log.info("[finaliza] CartaoController - consultaSaldoCartao");
        return saldoCartao;
    }
}
