package com.white.hellousagichan.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsagiMQConfigRequest {
    @Value("${spring.rabbitmq.queue.name}")
    private String queueName;
    @Value("${spring.rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${spring.rabbitmq.routing.key}")
    private String routingKey;

    // spring beans for rabbitmq queue
    @Bean
    public Queue usagiQueue() {
        return QueueBuilder
                .durable(queueName)
                .build();
    }

    // spring beans for rabbitmq exchange
    @Bean
    public TopicExchange usagiExchange() {
        return new TopicExchange(exchangeName);
    }
    @Bean
    //binding the queue to the exchange
    public Binding declareBinding() {
        return BindingBuilder.bind(usagiQueue()).to(usagiExchange()).with(routingKey);
    }


    //Connection factory
    //RabbitTemplate
    //RabbitAdmin
    //All of this is auto-configured by Spring Boot
    //We can override the default configuration by providing our own configuration
}
