package com.wallet.transferencia.service;

import com.wallet.transferencia.dto.TransacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransferenciaService {

    private final RestTemplate client;

    @Autowired
    public TransferenciaService(RestTemplate client) {
        this.client = client;
    }

    public void realizarCreditoTransferencia(TransacaoDTO transferenciaDTO){

        client.postForEntity("http://localhost:8082/transacao/creditar", transferenciaDTO, String.class);

    }

    public void realizarDebitoTransferencia(TransacaoDTO transferenciaDTO){

        client.postForEntity("http://localhost:8082/transacao/debitar", transferenciaDTO, String.class);

    }
}
