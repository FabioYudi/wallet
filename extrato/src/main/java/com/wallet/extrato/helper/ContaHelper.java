package com.wallet.extrato.helper;

import org.springframework.stereotype.Component;

@Component
public class ContaHelper {

    public boolean verificarContaValida(String numeroConta){
        if(numeroConta.isBlank() || numeroConta.length() != 4){
            return false;
        }

        return true;
    }
}
