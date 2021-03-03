package com.example.producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private KafkaTemplate<String, String> producer;

    public  KafkaProducer(KafkaTemplate<String, String> producer){
        this.producer = producer;
    }

    public void send(String message){
        producer.send("test", message);
    }
}
