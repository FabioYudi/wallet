package com.wallet.pagamentos.service;

import com.wallet.pagamentos.dto.PagamentoDTO;
import com.wallet.pagamentos.facade.PagamentoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PagamentosService {

    private final RestTemplate client;

    @Autowired
    public PagamentosService(RestTemplate client) {
        this.client = client;
    }

    public void realizarPagamento(PagamentoDTO pagamentoDTO){

        client.postForEntity("http://localhost:8082/transacao/debitar", pagamentoDTO, String.class);
        
    }
}
