package com.medsci.hello.spring.boot.config;

import com.medsci.hello.spring.boot.listener.StartupListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: Arnold
 * @date: 2021/4/30 10:19
 */
@Configuration
public class ListenerConfig {
    @Bean
    public StartupListener startupListener(){
        return new StartupListener();
    }
}
