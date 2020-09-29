package com.medsci.hello.spring.boot.exception;

import com.medsci.hello.spring.boot.common.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @description:
 * @author: 学长
 * @date: 2020/9/29 09:15
 */
@RestControllerAdvice
public class GlobalException {
    private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseBean classNotFoundException(ClassNotFoundException e){
        return ResponseBean.error("class not found！");
    }
}
