package com.medsci.hello.spring.boot.strategy;


/**
 * @description:
 * @author: 学长
 * @date: 2020/10/15 18:38
 */
public interface RSAHandler {
    String handler(String data, String Key) throws Exception;
}
