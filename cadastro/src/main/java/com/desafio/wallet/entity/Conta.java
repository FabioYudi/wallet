package com.desafio.wallet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    private final String numero;

    private final BigDecimal saldo;

    public Conta(long id, String numero, BigDecimal saldo) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Conta(String numero, BigDecimal saldo) {
        this.id = null;
        this.numero = numero;
        this.saldo = saldo;
    }


    public BigDecimal getSaldo() {
        return saldo;
    }

    public long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }
}
