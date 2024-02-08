package com.vrbeneficios.cartao.application.service;

import com.vrbeneficios.cartao.application.api.CartaoRequest;
import com.vrbeneficios.cartao.application.api.CartaoResponse;
import com.vrbeneficios.cartao.application.repository.CartaoRepository;
import com.vrbeneficios.cartao.dominio.Cartao;
import com.vrbeneficios.cliente.application.repository.ClienteRepository;
import com.vrbeneficios.cliente.dominio.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
