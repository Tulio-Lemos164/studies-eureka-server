package br.com.mscredit_appraiser.mqueue;

import br.com.mscredit_appraiser.model.CardIssuanceData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RequestCardIssuancePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queueCardIssuance;

    @RabbitHandler
    public void requestCardIssuance(CardIssuanceData data) throws JsonProcessingException{
        String json = convertIntoJson(data);
        rabbitTemplate.convertAndSend(queueCardIssuance.getName(), json);
    }

    private String convertIntoJson(CardIssuanceData data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(data);
    }
}
