package com.wallet.extrato.service;

import com.wallet.extrato.entity.Transacao;
import com.wallet.extrato.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public void gravarTransacao(Transacao transacao){
        transacaoRepository.save(transacao);
    }
}
