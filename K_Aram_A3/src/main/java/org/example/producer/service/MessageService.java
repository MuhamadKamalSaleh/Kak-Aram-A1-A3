package org.example.producer.service;

import org.example.producer.model.UserMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public MessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String name, String email) {
        UserMessage message = new UserMessage();
        message.setName(name);
        message.setEmail(email);
        message.setTimestamp(LocalDateTime.now());

        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);

        logger.info("Message sent successfully: {}", message);
    }
}