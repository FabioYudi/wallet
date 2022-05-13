package com.desafio.wallet.dto;

import java.math.BigDecimal;

public class ContaDTO {

    private final String numeroConta;
    private final BigDecimal saldo;

    public ContaDTO(String numeroConta, BigDecimal saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public ContaDTO(String numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = null;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
