package com.wallet.extrato.entity;

import com.wallet.extrato.enums.TipoTransacao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String numeroConta;

    @Enumerated(EnumType.STRING)
    private  TipoTransacao tipoTransacao;

    @Temporal(TemporalType.TIMESTAMP)
    private  Date dataHoraTransacao;

    private  String descricao;

    private  BigDecimal valor;

    public Transacao(){}
    public Transacao(Long id, String numeroConta, TipoTransacao tipoTransacao, Date dataHoraTransacao, String descricao, BigDecimal valor) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.tipoTransacao = tipoTransacao;
        this.dataHoraTransacao = dataHoraTransacao;
        this.descricao = descricao;

        this.valor = valor;
    }

    public Transacao(String numeroConta, TipoTransacao tipoTransacao, Date dataHoraTransacao, String descricao, BigDecimal valor) {
        this.valor = valor;

        this.id = null;
        this.numeroConta = numeroConta;
        this.tipoTransacao = tipoTransacao;
        this.dataHoraTransacao = dataHoraTransacao;
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public Date getDataHoraTransacao() {
        return dataHoraTransacao;
    }

    public String getDescricao() {
        return descricao;
    }
}
