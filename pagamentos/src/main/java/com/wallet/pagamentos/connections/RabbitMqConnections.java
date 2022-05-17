package com.wallet.pagamentos.connections;

import com.wallet.pagamentos.constantes.RabbitMqConstantes;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class RabbitMqConnections {
    private static final String NOME_EXCHANGE = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMqConnections(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila(String nomeFila){
        return new Queue(nomeFila, true, false, false);
    }

    private DirectExchange trocaDireta(){
        return new DirectExchange(NOME_EXCHANGE);
    }


    private Binding relacionamento(Queue fila, DirectExchange troca){
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(),
                fila.getName(), null);
    }

    @PostConstruct
    private void adicionar(){
        Queue filaPagamentos = this.fila(RabbitMqConstantes.FILA_PAGAMENTO);

        DirectExchange troca = this.trocaDireta();

        Binding ligacao = this.relacionamento(filaPagamentos, troca);

        this.amqpAdmin.declareQueue(filaPagamentos);
        this.amqpAdmin.declareExchange(troca);
        this.amqpAdmin.declareBinding(ligacao);
    }
}
