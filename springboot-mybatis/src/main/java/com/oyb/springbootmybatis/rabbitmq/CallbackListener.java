package com.oyb.springbootmybatis.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
@RabbitListener(queues =  AmqpConfig.FOO_QUEUE)
public class CallbackListener {

    private static  final Logger logger  = LoggerFactory.getLogger(CallbackListener.class);

    /** 设置交换机类型  */
    @Bean
    public DirectExchange defaultExchange() {
        /**
         * DirectExchange:按照routingkey分发到指定队列
         * TopicExchange:多关键字匹配
         * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
         * HeadersExchange ：通过添加属性key-value匹配
         */
        return new DirectExchange(AmqpConfig.FOO_EXCHANGE);
    }

    @Bean
    public Queue fooQueque(){
        return  new Queue(AmqpConfig.FOO_QUEUE);
    }


    @RabbitHandler
    public void process(@Payload String foo){
        logger.info("rabbit.mq 接收消息={}",foo);
    }
    /** 将队列绑定到交换机 */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(fooQueque()).to(defaultExchange()).with(AmqpConfig.FOO_ROUTINGKEY);
    }
}
