package com.medsci.hello.spring.boot.controller;

import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.service.ForestService;
import com.medsci.hello.spring.boot.service.MyForestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Arnold
 * @date: 2021/5/21 13:24
 */
@RestController
@RequestMapping("api/forest")
public class ForestController {
    @Autowired
    private MyForestService myForestService;

    @GetMapping("api")
    public ResponseBean api(){
        return ResponseBean.ok("forest");
    }

    @GetMapping("api2")
    public ResponseBean api2(){
        return ResponseBean.ok(myForestService.api2());
    }
}
