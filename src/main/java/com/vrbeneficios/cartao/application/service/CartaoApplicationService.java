package com.vrbeneficios.cartao.application.service;

import com.vrbeneficios.cartao.application.api.CartaoRequest;
import com.vrbeneficios.cartao.application.api.CartaoResponse;
import com.vrbeneficios.cartao.application.api.CartaoSaldoResponse;
import com.vrbeneficios.cartao.application.api.TransacaoRequest;
import com.vrbeneficios.cartao.application.repository.CartaoRepository;
import com.vrbeneficios.cartao.dominio.Cartao;
import com.vrbeneficios.cliente.application.repository.ClienteRepository;
import com.vrbeneficios.cliente.dominio.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class CartaoApplicationService implements CartaoService {
    private final CartaoRepository cartaoRepository;
    private final ClienteRepository clienteRepository;
    @Override
    public CartaoResponse criaCartao(String idCliente,CartaoRequest cartaoRequest) {
        log.info("[inicia] CartaoApplicationService - criaCartao");
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        Cartao novoCartao = cartaoRepository.salva(new Cartao(cliente,cartaoRequest));
        log.info("[finaliza] CartaoApplicationService - criaCartao");
        return new CartaoResponse(novoCartao);
    }

    @Override
    public CartaoSaldoResponse consultaSaldoCartao(String numeroCartao) {
        log.info("[inicia] CartaoApplicationService - consultaSaldoCartao");
        Cartao cartao = cartaoRepository.buscaCartaoPeloNumero(numeroCartao);
        log.info("[finaliza] CartaoApplicationService - consultaSaldoCartao");
        return CartaoSaldoResponse.builder().saldo(cartao.getSaldo()).build();
    }
    @Transactional
    @Override
    public void realizaTransacao(TransacaoRequest transacaoRequest) {
        log.info("[inicia] CartaoApplicationService - realizaTransacao");
        Cartao cartao = cartaoRepository.buscaCartaoPeloNumero(transacaoRequest.getNumeroCartao());
        cartao.validaTransacao(transacaoRequest);
        cartaoRepository.salva(cartao);
        log.info("[finaliza] CartaoApplicationService - realizaTransacao");
    }
}
