package com.vrbeneficios.cartao.infra;

import com.vrbeneficios.cartao.application.repository.CartaoRepository;
import com.vrbeneficios.cartao.dominio.Cartao;
import com.vrbeneficios.handler.APIException;
import com.vrbeneficios.handler.ProblemType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class CartaoInfraRepository implements CartaoRepository {
    private final CartaoSpringDataJPA cartaoSpringDataJPA;
    @Override
    public Cartao salva(Cartao cartao) {
        log.info("[inicia] CartaoInfraRepository - salva");
        try {
        cartaoSpringDataJPA.save(cartao);
    } catch (DataIntegrityViolationException e) {
        throw APIException.negocio(String.format( "Cartão duplicado. Um cartão com o número %s já existe.",
                cartao.getNumeroCartao()), ProblemType.CARTAO_DUPLICADO);}
        log.info("[finaliza] CartaoInfraRepository - salva");
        return cartao;
    }
}
