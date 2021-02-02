package com.medsci.hello.spring.boot.config;

import com.medsci.hello.spring.boot.exception.MyRestErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @description: 配置RestTemplateConfig
 * @author: 学长
 * @date: 2021/1/29 09:08
 */
@Configuration
@Slf4j
public class RestTemplateConfig {
    /**
     * 配置RestTemplate
     * @param factory
     * @return
     */
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        RestTemplate restTemplate = new RestTemplate(factory);

        //解决中文乱码
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        //处理异常
        restTemplate.setErrorHandler(new MyRestErrorHandler());

        log.info("RestTemplate注入成功！");

        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        //创建httpClient 简单工厂
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        // 设置链接超时
        factory.setConnectTimeout(5000);

        // 设置读取超时
        factory.setReadTimeout(5000);

        return  factory;
    }
}
