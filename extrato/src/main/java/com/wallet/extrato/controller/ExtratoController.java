package com.wallet.extrato.controller;

import com.wallet.extrato.constantes.ContaConstantes;
import com.wallet.extrato.entity.Transacao;
import com.wallet.extrato.facade.ContaInput;
import com.wallet.extrato.helper.ContaHelper;
import com.wallet.extrato.helper.ResponseHelper;
import com.wallet.extrato.service.ContaService;
import com.wallet.extrato.service.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wallet.extrato.constantes.ContaConstantes.MENSAGEM_CONTA_INVALIDA;

@RestController
@RequestMapping("/extrato")
public class ExtratoController {


    private final SaldoService saldoService;

    private final ContaService contaService;

    private final ContaHelper contaHelper;

    @Autowired
    public ExtratoController(SaldoService saldoService, ContaService contaService, ContaHelper contaHelper) {
        this.saldoService = saldoService;
        this.contaService = contaService;
        this.contaHelper = contaHelper;
    }

    @GetMapping("/saldo")
    public ResponseEntity consultarSaldo(@RequestParam String numeroConta){
        if(!contaHelper.verificarContaValida(numeroConta)){
            return ResponseHelper.BadRequest(MENSAGEM_CONTA_INVALIDA);
        }

        return saldoService.consultarSaldo(numeroConta);


    }


    @GetMapping("/movimentacao")
    public ResponseEntity consultarMovimentacao(@RequestParam String numeroConta){
        if(!contaHelper.verificarContaValida(numeroConta)){
            return ResponseHelper.BadRequest(MENSAGEM_CONTA_INVALIDA);
        }

        List<Transacao> transacoes = saldoService.consultarMovimentacao(numeroConta);
        if(transacoes.isEmpty()){
           return ResponseHelper.NoContent("Não foram encontradas transações para está conta");
        }
        return ResponseHelper.Success(transacoes);
    }

    @PostMapping("/criarConta")
    public ResponseEntity criarConta(@RequestBody ContaInput contaInput){
        return ResponseHelper.Success(contaService.criarConta(contaInput.toContaEntity()));
    }
}
