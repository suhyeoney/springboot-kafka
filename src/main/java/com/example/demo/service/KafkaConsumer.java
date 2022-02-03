package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.utils.DateFormat;

import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Log
@Service
public class KafkaConsumer implements ConsumerSeekAware {

    @KafkaListener(topics = "first_topic", groupId = "${spring.kafka.consumer.group-id}") // Kafka 브로커로부터 메시지를 받기 위한 리스너
    public void consume(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition, @Header(KafkaHeaders.OFFSET) Integer offset) throws Exception {

        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("returnResult", "S");
        returnMap.put("message", "[" + new DateFormat().convertDateFormat() + "] " + message);
        returnMap.put("partition", partition);
        returnMap.put("offset", offset);

        log.info(returnMap.toString());

    }

    @Override
    public void registerSeekCallback(ConsumerSeekCallback callback) {
        ConsumerSeekAware.super.registerSeekCallback(callback);
    }

    @Override
    public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
        ConsumerSeekAware.super.onPartitionsAssigned(assignments, callback);
    }

    @Override
    public void onIdleContainer(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
        ConsumerSeekAware.super.onIdleContainer(assignments, callback);
    }

}
