package com.coffee.CoffeeApplication.KafkaConsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafkaTest", groupId = "coffeeConsumer")
    public void listen(String message) {
        System.out.println("ZernoInfo: "+message);
    }
}
