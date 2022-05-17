package com.wallet.pagamentos.service;

import dto.PagamentoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PagamentosService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public PagamentosService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void enviarPagamento(String nomeFila, Object mensagem){
        this.rabbitTemplate.convertAndSend(nomeFila, mensagem);
    }
}
