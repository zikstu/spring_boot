package com.medsci.hello.spring.boot.exception;

/**
 * @description:
 * @author: 学长
 * @date: 2021/2/1 21:02
 */
public class MyRestException extends RuntimeException{
    public MyRestException(String message){
        super(message);
    }
}
