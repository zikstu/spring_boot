package com.medsci.hello.spring.boot.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface RSATypeAnnotation {
    /**
     * RSA key类型 （pri or pub）
     * @return
     */
    String keyType();

    /**
     * 加密或者解密操作（enc or dec）
     * @return
     */
    String action();
}
