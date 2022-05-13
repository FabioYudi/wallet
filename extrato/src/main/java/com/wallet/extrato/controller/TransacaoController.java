package com.wallet.extrato.controller;

import com.wallet.extrato.enums.TipoTransacao;
import com.wallet.extrato.facade.TransacaoInput;
import com.wallet.extrato.service.SaldoService;
import com.wallet.extrato.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final SaldoService saldoService;
    private final TransacaoService transacaoService;

    @Autowired
    public TransacaoController(SaldoService saldoService, TransacaoService transacaoService) {
        this.saldoService = saldoService;
        this.transacaoService = transacaoService;
    }



    @PostMapping("/debitar")
    public  void debitar(@RequestBody TransacaoInput transacaoInput){
        saldoService.debitar(transacaoInput.getValor(), transacaoInput.getNumeroConta());
        transacaoService.gravarTransacao(transacaoInput.toTransacaoEntity(TipoTransacao.DEBITO));

    }

    @PostMapping("/creditar")
    public void creditar(@RequestBody TransacaoInput transacaoInput){
        saldoService.creditar(transacaoInput.getValor(), transacaoInput.getNumeroConta());
        transacaoService.gravarTransacao(transacaoInput.toTransacaoEntity(TipoTransacao.CREDITO));


    }


}
