package com.wallet.extrato.controller;

import com.wallet.extrato.entity.Transacao;
import com.wallet.extrato.facade.ContaInput;
import com.wallet.extrato.facade.SaldoOutPut;
import com.wallet.extrato.helper.ResponseHelper;
import com.wallet.extrato.service.ContaService;
import com.wallet.extrato.service.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extrato")
public class ExtratoController {


    private final SaldoService saldoService;

    private final ContaService contaService;

    @Autowired
    public ExtratoController(SaldoService saldoService, ContaService contaService) {
        this.saldoService = saldoService;
        this.contaService = contaService;
    }

    @GetMapping("/saldo")
    public ResponseEntity consultarSaldo(@RequestParam String numeroConta){

        SaldoOutPut saldoOutPut =  saldoService.consultarSaldo(numeroConta);
        return ResponseHelper.Success(saldoOutPut);
    }


    @GetMapping("/movimentacao")
    public ResponseEntity consultarMovimentacao(@RequestParam String numeroConta){

        List<Transacao> transacoes = saldoService.consultarMovimentacao(numeroConta);
        return ResponseHelper.Success(transacoes);
    }

    @PostMapping("/criarConta")
    public void criarConta(@RequestBody ContaInput contaInput){
        contaService.criarConta(contaInput.toContaEntity());
    }
}
