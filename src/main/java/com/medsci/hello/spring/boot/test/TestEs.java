package com.medsci.hello.spring.boot.test;



import com.medsci.hello.spring.boot.service.impl.EsService;

import java.io.IOException;


/**
 * @description:
 * @author: 学长
 * @date: 2021/3/3 15:51
 */
public class TestEs {

    public static void main(String[] args) throws IOException {
        EsService esService = new EsService();

        esService.createIndex();
    }
}
