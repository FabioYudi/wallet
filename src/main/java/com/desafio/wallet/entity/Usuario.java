package com.desafio.wallet.entity;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue()
    private final Long id;

    private final String email;
    private final String nome;

    @OneToOne(cascade=CascadeType.PERSIST)
    private final Conta conta;

    public Usuario(Long id, String email, String nome, Conta conta) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.conta = conta;
    }

    public Usuario(String email, String nome, Conta conta) {
        this.id = null;
        this.email = email;
        this.nome = nome;
        this.conta = conta;
    }


    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
