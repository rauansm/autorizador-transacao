package com.vrbeneficios.cartao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/cartao")
public interface CartaoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CartaoResponse criaCartao (@PathVariable String idCliente,
           @Valid @RequestBody CartaoRequest cartaoRequest);
}
