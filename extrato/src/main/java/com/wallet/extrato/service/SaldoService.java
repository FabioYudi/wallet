package com.wallet.extrato.service;

import com.wallet.extrato.entity.Conta;
import com.wallet.extrato.entity.Transacao;
import com.wallet.extrato.facade.SaldoOutPut;
import com.wallet.extrato.repository.ContaRepository;
import com.wallet.extrato.repository.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaldoService {

    private final SaldoRepository saldoRepository;
    private final ContaRepository contaRepository;

    @Autowired
    public SaldoService(SaldoRepository saldoRepository, ContaRepository contaRepository) {
        this.saldoRepository = saldoRepository;
        this.contaRepository = contaRepository;
    }

    public SaldoOutPut consultarSaldo(String numeroConta) {
        Conta conta = contaRepository.findByNumero(numeroConta);
        return new SaldoOutPut(conta.getSaldo(), conta.getNumero());
    }

    public void debitar(BigDecimal valor, String numeroConta) {
        Conta conta = contaRepository.findByNumero(numeroConta);
        conta.setSaldo(conta.getSaldo().subtract(valor));
        contaRepository.save(conta);
    }

    public void creditar(BigDecimal valor, String numeroConta) {
        Conta conta = contaRepository.findByNumero(numeroConta);
        conta.setSaldo(conta.getSaldo().add(valor));
        contaRepository.save(conta);

    }

    public List<Transacao> consultarMovimentacao(String numeroConta) {
        return saldoRepository.findByNumeroConta(numeroConta);
    }


}
