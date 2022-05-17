package com.desafio.wallet.facade;

import com.desafio.wallet.entity.Usuario;

public class UsuarioInput {

    private String nome;
    private String email;

    public UsuarioInput(){}

    public UsuarioInput(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Usuario toUsuarioEntity(String numeroConta){

        return new Usuario(email, nome, numeroConta);
    }
}
