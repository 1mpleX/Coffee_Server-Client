package com.coffee.Kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyKafkaCfg {

    @Bean
    public NewTopic coffeeTopic(){
        return new NewTopic("kafkaTest", 1, (short) 1);
    }

}
