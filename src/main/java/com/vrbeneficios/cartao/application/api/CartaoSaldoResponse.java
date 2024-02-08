package com.vrbeneficios.cartao.application.api;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class CartaoSaldoResponse {
    private BigDecimal saldo;
}
