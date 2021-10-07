package com.zupacademy.transacoes.consomeTransacao;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsomeTransacao {

    @KafkaListener(topics = "transacoes")
    private void consome(ConsumerRecord<String, String> record){
        System.out.println("-------------------------------");
        System.out.println("Processing new order");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
    }
}
