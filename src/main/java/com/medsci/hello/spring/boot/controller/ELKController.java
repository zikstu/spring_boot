package com.medsci.hello.spring.boot.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 学长
 * @date: 2021/3/4 22:05
 */
@Slf4j
@Api(tags = "ELK")
@RestController
@RequestMapping(value = {"/elk"})
public class ELKController {
    @ApiOperationSupport(author = "学长")
    @ApiOperation(value = "index", notes = "测试")
    @GetMapping("/index")
    public String index(){
        log.error("error 错误信息==========");
        log.warn("warn 错误信息==========");
        log.info("info 错误信息==========");
        return "测试";
    }
}
