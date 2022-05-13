package com.wallet.extrato.facade;

import com.wallet.extrato.entity.Transacao;
import com.wallet.extrato.enums.TipoTransacao;

import java.math.BigDecimal;
import java.util.Date;

public class TransacaoInput {
    private final String descricao;
    private final BigDecimal valor;
    private final String numeroConta;

    public TransacaoInput(String descricao, BigDecimal valor, String numeroConta) {
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

    public Transacao toTransacaoEntity(TipoTransacao tipoTransacao){
        return new Transacao(numeroConta, tipoTransacao, new Date(), descricao, valor);
    }
}
