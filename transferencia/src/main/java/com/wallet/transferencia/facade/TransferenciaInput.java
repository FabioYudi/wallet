package com.wallet.transferencia.facade;

import com.wallet.transferencia.dto.TransacaoDTO;

import java.math.BigDecimal;

public class TransferenciaInput {

    private final String numeroContaDestino;
    private final String numeroContaOrigem;
    private final BigDecimal valor;

    public TransferenciaInput(String numeroContaDestino, String numeroContaOrigem, BigDecimal valor) {
        this.numeroContaDestino = numeroContaDestino;
        this.numeroContaOrigem = numeroContaOrigem;
        this.valor = valor;
    }

    public String getNumeroContaDestino() {
        return numeroContaDestino;
    }

    public String getNumeroContaOrigem() {
        return numeroContaOrigem;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TransacaoDTO toTransacaoDTO(String descricao, String numeroConta){
        return new TransacaoDTO( descricao, valor, numeroConta);
    }
}
