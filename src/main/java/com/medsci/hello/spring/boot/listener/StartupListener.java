package com.medsci.hello.spring.boot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description:
 * @author: Arnold
 * @date: 2021/4/30 10:13
 */
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(StartupListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextClosedEvent) {
        try {
            logger.info("get local ip " + InetAddress.getLocalHost().getHostAddress());
        }catch (UnknownHostException e){
            logger.error("UnknownHostException");
        }
    }
}
