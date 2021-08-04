package com.medsci.hello.spring.boot.controller;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHi()
    {
        return "Hello Spring Boot";
    }

    @Autowired
    private StringEncryptor stringEncryptor;

    @GetMapping("api/encString")
    public String encString(@RequestParam("context") String context) {
        return stringEncryptor.encrypt(context);
    }
}
