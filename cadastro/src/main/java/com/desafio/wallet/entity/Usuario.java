package com.desafio.wallet.entity;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue()
    private final Long id;

    private final String email;
    private final String nome;

    private final String numeroConta;

    public Usuario(Long id, String email, String nome, String numeroConta) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.numeroConta = numeroConta;
    }

    public Usuario(String email, String nome, String numeroConta) {
        this.numeroConta = numeroConta;
        this.id = null;
        this.email = email;
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
