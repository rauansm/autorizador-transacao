package com.vrbeneficios.cartao.infra;

import com.vrbeneficios.cartao.dominio.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoSpringDataJPA extends JpaRepository<Cartao,String> {
}
