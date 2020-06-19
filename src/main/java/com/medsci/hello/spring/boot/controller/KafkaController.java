package com.medsci.hello.spring.boot.controller;

import com.medsci.hello.spring.boot.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 学长
 * @date: 2020/6/9 16:30
 */
@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public void sendMsg(){
        kafkaProducer.send("hello kafka");
    }
}
