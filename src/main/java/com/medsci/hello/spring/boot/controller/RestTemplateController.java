package com.medsci.hello.spring.boot.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.medsci.hello.spring.boot.common.ResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.hasor.utils.json.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


/**
 * @description: 测试restTemplate
 * @author: 学长
 * @date: 2021/1/29 09:19
 */
@RestController
@RequestMapping("/restTemplate")
@Api(tags = "HTTP请求")
public class RestTemplateController{
    private final static Logger logger = LoggerFactory.getLogger(RestTemplateController.class);

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/postForEntity")
    @ApiOperation("测试post请求")
    @ApiOperationSupport(author = "学长")
    public ResponseBean postForEntity(@RequestParam("url") String url, @RequestParam("email") String email, @RequestParam("password") String password, @RequestHeader HttpHeaders httpHeaders){
        //设置header
        HttpHeaders headers = new HttpHeaders();

        //入参
        Map<String, String> map = new HashMap<>();

        map.put("email", email);
        map.put("password", password);

        String first = httpHeaders.getFirst("Authorization");

        logger.info(first);

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, map, String.class);


        HttpStatus statusCode = stringResponseEntity.getStatusCode();

        int statusCodeValue = stringResponseEntity.getStatusCodeValue();

        HttpHeaders headers1 = stringResponseEntity.getHeaders();

        String body = stringResponseEntity.getBody();

        Object parse = JSON.parse(body);

        return ResponseBean.ok(parse);
    }
}
