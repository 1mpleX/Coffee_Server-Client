package com.coffee.Kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MyKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("kafkaTest", message);
    }

}
