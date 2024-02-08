package com.vrbeneficios.cartao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/cartao")
public interface CartaoAPI {

    @PostMapping("/cliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.CREATED)
    CartaoResponse criaCartao (@PathVariable String idCliente,
           @Valid @RequestBody CartaoRequest cartaoRequest);

    @GetMapping("/{numeroCartao}")
    @ResponseStatus(code = HttpStatus.OK)
    CartaoSaldoResponse consultaSaldoCartao (@PathVariable String numeroCartao);
}
