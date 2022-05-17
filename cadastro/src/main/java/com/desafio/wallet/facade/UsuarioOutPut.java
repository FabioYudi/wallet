package com.desafio.wallet.facade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioOutPut {

    @JsonProperty("numero_conta")
    private final String numeroConta;

    @JsonProperty("nome_usuario")
    private final String nomeUsuario;

    public UsuarioOutPut(String numeroConta, String nomeUsuario) {
        this.numeroConta = numeroConta;
        this.nomeUsuario = nomeUsuario;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}
