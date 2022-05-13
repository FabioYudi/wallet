package com.wallet.pagamentos.controller;

import com.wallet.pagamentos.facade.PagamentoInput;
import com.wallet.pagamentos.service.PagamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentosController {

    private final PagamentosService pagamentosService;

    @Autowired
    public PagamentosController(PagamentosService pagamentosService) {
        this.pagamentosService = pagamentosService;
    }


    @PostMapping("/pagar")
    public void pagar(@RequestBody PagamentoInput pagamentoInput){
        pagamentosService.realizarPagamento(pagamentoInput.toPagamentoDTO());
    }

}
