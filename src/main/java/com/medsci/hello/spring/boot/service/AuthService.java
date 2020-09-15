package com.medsci.hello.spring.boot.service;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/14 09:57
 */
public interface AuthService {
    String login(String username, String password) throws Exception;

    Integer register(String username, String password) throws Exception;
}
