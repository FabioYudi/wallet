package com.wallet.pagamentos.facade;

import com.wallet.pagamentos.dto.PagamentoDTO;

import java.math.BigDecimal;

public class PagamentoInput {

    private final String codigoBarras;
    private final BigDecimal valor;
    private final String descricao;
    private final String numeroConta;

    public PagamentoInput(String codigoBarras, BigDecimal valor, String descricao, String numeroConta) {
        this.codigoBarras = codigoBarras;
        this.valor = valor;
        this.descricao = descricao;
        this.numeroConta = numeroConta;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public PagamentoDTO toPagamentoDTO(){
        return new PagamentoDTO(codigoBarras, valor, descricao, numeroConta);
    }

}
