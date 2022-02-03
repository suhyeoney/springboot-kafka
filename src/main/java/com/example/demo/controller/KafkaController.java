package com.example.demo.controller;

import com.example.demo.service.KafkaConsumer;
import com.example.demo.service.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    
    // @GetMapping(value = "/index")
    // public String index() {
    //     return "Test Controller works successfully!";
    // }

    private final KafkaProducer kafkaProducer;
    private final KafkaConsumer kafkaConsumer;

    @Autowired
    KafkaController(KafkaProducer kafkaProducer, KafkaConsumer kafkaConsumer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaConsumer = kafkaConsumer;
    }

    @PostMapping(value = "/publish")
    public String  sendMessage(@RequestParam("message") String message) {
        
        this.kafkaProducer.sendMessage(message);
        
        return "S";
    }

}
