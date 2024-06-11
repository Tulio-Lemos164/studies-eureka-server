package br.com.mscards.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CardIssuanceSubscriber {

    @RabbitListener(queues = "${mq.queues.card-issuance}")
    public void receiveIssuanceRequest(@Payload String payload){
        System.out.println(payload);
    }
}
