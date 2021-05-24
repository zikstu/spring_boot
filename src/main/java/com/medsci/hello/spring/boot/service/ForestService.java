package com.medsci.hello.spring.boot.service;

import com.dtflys.forest.annotation.Request;

/**
 * @author: Arnold
 * @date: 2021/5/21 13:25
 */
public interface ForestService {
    @Request(url = "https://baidu.com")
    String api();
}
