package com.medsci.hello.spring.boot.service.impl;

import com.medsci.hello.spring.boot.service.ForestService;
import com.medsci.hello.spring.boot.service.MyForestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Arnold
 * @date: 2021/5/21 14:05
 */
@Service
public class MyForestServiceImpl implements MyForestService {
    @Autowired
    private ForestService forestService;

    @Override
    public String api2() {
        String s = forestService.api();
        System.out.println(s);
        return s;
    }
}
