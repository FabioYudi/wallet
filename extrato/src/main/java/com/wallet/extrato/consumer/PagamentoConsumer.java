package com.wallet.extrato.consumer;

import com.wallet.extrato.constantes.RabbitMqConstantes;
import com.wallet.extrato.enums.TipoTransacao;
import com.wallet.extrato.helper.ContaHelper;
import com.wallet.extrato.helper.ResponseHelper;
import com.wallet.extrato.service.SaldoService;
import com.wallet.extrato.service.TransacaoService;
import dto.PagamentoDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static com.wallet.extrato.constantes.ContaConstantes.MENSAGEM_CONTA_INVALIDA;

@Component
public class PagamentoConsumer {

    private final SaldoService saldoService;
    private final TransacaoService transacaoService;
    private final ContaHelper contaHelper;

    @Autowired
    public PagamentoConsumer(SaldoService saldoService, TransacaoService transacaoService, ContaHelper contaHelper) {
        this.saldoService = saldoService;
        this.transacaoService = transacaoService;
        this.contaHelper = contaHelper;
    }


    @RabbitListener(queues = RabbitMqConstantes.FILA_PAGAMENTO)
    private void consumir(PagamentoDTO pagamentoDTO){

        saldoService.debitar(pagamentoDTO.getValor(), pagamentoDTO.getNumeroConta());
        //transacaoService.gravarTransacao(transacaoInput.toTransacaoEntity(TipoTransacao.DEBITO));


    }
}
