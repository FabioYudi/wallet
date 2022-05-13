package com.wallet.transferencia.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransacaoDTO {
    private final String descricao;
    private final BigDecimal valor;
    private final String numeroConta;

    public TransacaoDTO(String descricao, BigDecimal valor, String numeroConta) {
        this.descricao = descricao;
        this.valor = valor;
        this.numeroConta = numeroConta;
    }


    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNumeroConta() {
        return numeroConta;
    }


}
