package com.wallet.extrato.facade;

import java.math.BigDecimal;

public class SaldoOutPut {

    private final BigDecimal saldo;
    private final String numeroConta;

    public SaldoOutPut(BigDecimal saldo, String numeroConta) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
