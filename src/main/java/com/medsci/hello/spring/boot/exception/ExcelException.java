package com.medsci.hello.spring.boot.exception;

/**
 * @description: Excel 解析 Exception
 * @author: 学长
 * @date: 2020/9/21 15:27
 */
public class ExcelException extends RuntimeException{
    public ExcelException(String message){
        super(message);
    }
}
