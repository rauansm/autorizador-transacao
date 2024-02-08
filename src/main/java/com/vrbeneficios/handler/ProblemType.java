package com.vrbeneficios.handler;

import lombok.Getter;

@Getter
public enum ProblemType {

    REGISTRO_DUPLICADO("/dados-duplicado", "Dados duplicados"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    SALDO_INSUFICIENTE("/saldo-insuficiente", "Saldo insuficiente"),
    SENHA_INVALIDA("/senha-invalida", "Senha invalida"),
    CARTAO_INEXISTENTE("/cartao-inexistente", "Cartao inexistente"),
    CARTAO_DUPLICADO("/cartao-duplicado", "Cartao duplicado");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://vr.com.br" + path;
        this.title = title;
    }

}
