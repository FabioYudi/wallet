package com.wallet.transferencia.controller;

import com.wallet.transferencia.facade.TransferenciaInput;
import com.wallet.transferencia.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping("/transferir")
    public void transferir(@RequestBody TransferenciaInput transferenciaInput){
        String descricaoDestino = "Transferencia recebida de: " + transferenciaInput.getNumeroContaOrigem();
        transferenciaService.realizarCreditoTransferencia(transferenciaInput.toTransacaoDTO(descricaoDestino,
                transferenciaInput.getNumeroContaDestino()));

        String descricaoOrigem = "Transferencia feita para: " + transferenciaInput.getNumeroContaDestino();
        transferenciaService.realizarDebitoTransferencia(transferenciaInput.toTransacaoDTO(descricaoOrigem,
                transferenciaInput.getNumeroContaOrigem()));




    }
}
