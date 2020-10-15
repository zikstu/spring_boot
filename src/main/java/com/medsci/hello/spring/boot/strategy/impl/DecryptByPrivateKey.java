package com.medsci.hello.spring.boot.strategy.impl;

import com.medsci.hello.spring.boot.annotation.RSATypeAnnotation;
import com.medsci.hello.spring.boot.strategy.RSAHandler;
import com.medsci.hello.spring.boot.utils.RSAUtils;

/**
 * @description: 私钥解密
 * @author: 学长
 * @date: 2020/10/15 18:42
 */
@RSATypeAnnotation(keyType = "pri", action = "dec")
public class DecryptByPrivateKey implements RSAHandler {
    @Override
    public String handler(String data, String key) throws Exception {
        System.out.println("--私钥解密--");
        return RSAUtils.decryptByPrivateKey(data, key);
    }
}
