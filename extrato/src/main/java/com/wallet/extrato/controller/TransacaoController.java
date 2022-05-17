package com.wallet.extrato.controller;

import com.wallet.extrato.enums.TipoTransacao;
import com.wallet.extrato.facade.TransacaoInput;
import com.wallet.extrato.helper.ContaHelper;
import com.wallet.extrato.helper.ResponseHelper;
import com.wallet.extrato.service.SaldoService;
import com.wallet.extrato.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wallet.extrato.constantes.ContaConstantes.MENSAGEM_CONTA_INVALIDA;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final SaldoService saldoService;
    private final TransacaoService transacaoService;
    private final ContaHelper contaHelper;

    @Autowired
    public TransacaoController(SaldoService saldoService, TransacaoService transacaoService, ContaHelper contaHelper) {
        this.saldoService = saldoService;
        this.transacaoService = transacaoService;
        this.contaHelper = contaHelper;
    }



    @PostMapping("/debitar")
    public ResponseEntity debitar(@RequestBody TransacaoInput transacaoInput){
        if(!contaHelper.verificarContaValida(transacaoInput.getNumeroConta())){
            return ResponseHelper.BadRequest(MENSAGEM_CONTA_INVALIDA);
        }
        saldoService.debitar(transacaoInput.getValor(), transacaoInput.getNumeroConta());
        transacaoService.gravarTransacao(transacaoInput.toTransacaoEntity(TipoTransacao.DEBITO));

        return ResponseHelper.Success("Débito realizado com sucesso!");

    }

    @PostMapping("/creditar")
    public ResponseEntity creditar(@RequestBody TransacaoInput transacaoInput){
        if(!contaHelper.verificarContaValida(transacaoInput.getNumeroConta())){
            return ResponseHelper.BadRequest(MENSAGEM_CONTA_INVALIDA);
        }
        saldoService.creditar(transacaoInput.getValor(), transacaoInput.getNumeroConta());
        transacaoService.gravarTransacao(transacaoInput.toTransacaoEntity(TipoTransacao.CREDITO));

        return ResponseHelper.Success("Crédito realizado com sucesso!");

    }


}
