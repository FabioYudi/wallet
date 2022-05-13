package com.wallet.pagamentos.dto;

import java.math.BigDecimal;

public class PagamentoDTO {

    private final String codigoBarras;
    private final BigDecimal valor;
    private final String descricao;
    private final String numeroConta;

    public PagamentoDTO(String codigoBarras, BigDecimal valor, String descricao, String numeroConta) {
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
}
