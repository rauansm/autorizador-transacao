package com.vrbeneficios.cliente.application.api;

import com.vrbeneficios.cliente.dominio.Sexo;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
public class ClienteRequest {
    @NotBlank(message = "Nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "E-mail não pode estar em branco")
    @Email(message = "Endereço de e-mail incorreto")
    private String email;
    @NotNull
    private Sexo sexo;
}
