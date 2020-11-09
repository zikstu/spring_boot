package com.medsci.hello.spring.boot.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface RSATypeAnnotation {
    /**
     * RSA key类型 （private or public）
     * @return
     */
    String keyType();

    /**
     * 加密或者解密操作（encrypt or decrypt）
     * @return
     */
    String action();
}
