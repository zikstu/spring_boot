package com.medsci.hello.spring.boot.controller;

import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.redis.JedisUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @description:
 * @author: 学长
 * @date: 2020/11/16 17:16
 */
@RestController
@Api(tags = "Redis")
@RequestMapping(value = "/redis")
public class RedisController {
    @Autowired
    JedisUtil jedisUtil;

    @GetMapping(value = "getRedis")
    @ResponseBody
    public ResponseBean getRedis(){
        jedisUtil.set("20201116", "这是一个测试数据", 1);
        Long resExpire = jedisUtil.expire("20201116", 60, 1);
        String res = jedisUtil.get("20201116", 1);
        return ResponseBean.ok(res);
    }

    @GetMapping(value = "jedis")
    @ResponseBody
    public ResponseBean jedis(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.auth("123456");

        jedis.set("key", "value");

        String value = jedis.get("key");

        jedis.close();

        return ResponseBean.ok(value);
    }
}
