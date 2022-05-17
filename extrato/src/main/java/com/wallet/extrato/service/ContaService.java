package com.wallet.extrato.service;

import com.wallet.extrato.entity.Conta;
import com.wallet.extrato.repository.ContaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta criarConta(Conta conta){
       return contaRepository.save(conta);
    }
}
