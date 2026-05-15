package com.pb.payment_system.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "payment-topic", groupId = "payment-group")
    public void consumer(String message) {
        System.out.println("Received message" + message);
    }

}
