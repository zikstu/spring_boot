package com.medsci.hello.spring.boot.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: 学长
 * @date: 2021/3/4 15:20
 */
@Slf4j
public class TestLog4j2 {
    public static void main(String[] args) {
        log.info("info 日志信息============");
        log.error("error 日志信息============");
        log.warn("warn 日志信息============");
    }
}
