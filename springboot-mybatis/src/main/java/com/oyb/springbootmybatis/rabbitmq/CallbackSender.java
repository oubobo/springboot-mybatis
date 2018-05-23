package com.oyb.springbootmybatis.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 带ConfirmCallback的使用
 */
@Component
public class CallbackSender implements RabbitTemplate.ConfirmCallback{

    private static  final Logger  logger = LoggerFactory.getLogger(CallbackSender.class);

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void CallbackSender(RabbitTemplate  rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    public void send(String msg){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info("send: " + correlationData.getId());
        this.rabbitTemplate.convertAndSend(AmqpConfig.FOO_EXCHANGE, AmqpConfig.FOO_ROUTINGKEY, msg, correlationData);

    }


    /** 回调方法 */
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        logger.info("confirm: " + correlationData.getId());

    }
}
