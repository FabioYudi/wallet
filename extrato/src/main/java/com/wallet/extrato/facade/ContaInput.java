package com.wallet.extrato.facade;

import com.wallet.extrato.entity.Conta;

import java.math.BigDecimal;

public class ContaInput {

    private final String numeroConta;
    private final BigDecimal saldo;

    public ContaInput(String numeroConta, BigDecimal saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Conta toContaEntity(){
        return new Conta(numeroConta, BigDecimal.ZERO);
    }
}
