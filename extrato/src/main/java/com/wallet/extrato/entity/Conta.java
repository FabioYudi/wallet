package com.wallet.extrato.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private BigDecimal saldo;

    public Conta(){}

    public Conta(long id, String numero, BigDecimal saldo) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Conta(String numero, BigDecimal saldo) {
        super();
        this.id = null;
        this.numero = numero;
        this.saldo = saldo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }



    public String getNumero() {
        return numero;
    }
}