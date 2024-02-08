package com.vrbeneficios.cartao.infra;

import com.vrbeneficios.cartao.dominio.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoSpringDataJPA extends JpaRepository<Cartao,String> {
    Optional<Cartao> findCartaoByNumeroCartao(String numeroCartao);
}
