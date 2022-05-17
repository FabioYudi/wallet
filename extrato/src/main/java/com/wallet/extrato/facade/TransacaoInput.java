package com.wallet.extrato.facade;

import com.wallet.extrato.entity.Transacao;
import com.wallet.extrato.enums.TipoTransacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TransacaoInput implements Serializable {
    private  String descricao;
    private  BigDecimal valor;
    private  String numeroConta;

    public TransacaoInput(){}

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
