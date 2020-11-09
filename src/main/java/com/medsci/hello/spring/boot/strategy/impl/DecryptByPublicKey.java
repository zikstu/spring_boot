package com.medsci.hello.spring.boot.strategy.impl;

import com.medsci.hello.spring.boot.annotation.RSATypeAnnotation;
import com.medsci.hello.spring.boot.strategy.RSAHandler;
import com.medsci.hello.spring.boot.utils.RSAUtils;

/**
 * @description: 公钥解密
 * @author: 学长
 * @date: 2020/10/15 18:41
 */
@RSATypeAnnotation(keyType = "public", action = "decrypt")
public class DecryptByPublicKey implements RSAHandler {
    @Override
    public String handler(String data, String key) throws Exception {
        System.out.println("--公钥解密--");
        return RSAUtils.decryptByPublicKey(data, key);
    }
}
