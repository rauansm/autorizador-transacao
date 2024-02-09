package com.vrbeneficios.cartao.event;

import com.vrbeneficios.cartao.application.api.TransacaoRequest;
import com.vrbeneficios.cartao.dominio.Cartao;
import com.vrbeneficios.cartao.dominio.TransacaoAprovadaEvent;
import com.vrbeneficios.core.email.EnvioEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class NotificacaoClienteTransacaoAprovadaListener {
    @Autowired
    private EnvioEmail envioEmail;
    @TransactionalEventListener
    public void aoConfirmarTransacao(TransacaoAprovadaEvent event){
        Cartao cartao = event.getCartao();
        TransacaoRequest transacaoRequest = event.getTransacaoRequest();
        var mensagem = EnvioEmail.Mensagem.builder()
                .assunto(cartao.getDonoCartao().getNome() + " - Transação Aprovada")
                .corpo("transacao-aprovada.html")
                .variavel("cartao", cartao)
                .variavel("transacaoRequest", transacaoRequest)
                .destinatario(cartao.getDonoCartao().getEmail())
                .build();
        envioEmail.enviar(mensagem);
    }
}
