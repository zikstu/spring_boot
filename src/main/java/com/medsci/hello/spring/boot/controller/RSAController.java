package com.medsci.hello.spring.boot.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.medsci.hello.spring.boot.annotation.RSATypeAnnotation;
import com.medsci.hello.spring.boot.annotation.impl.RSATypeAnnotationImpl;
import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.dto.RSADto;
import com.medsci.hello.spring.boot.strategy.RSAHandler;
import com.medsci.hello.spring.boot.utils.RSAUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.hasor.web.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: 学长
 * @date: 2020/10/15 17:08
 */
@RestController
@Api(tags = "RSA加解密")
@RequestMapping("/api/rsa")
public class RSAController {
    private Map<RSATypeAnnotation, RSAHandler> rsaHandlerMap;

    @Autowired
    public void setRsaHandlerMap(List<RSAHandler> rsaHandlerList){
        //注入各种类型的rsa处理类
        rsaHandlerMap = rsaHandlerList
                .stream()
                .collect(Collectors.toMap(rsaHandler -> AnnotationUtils.findAnnotation(rsaHandler.getClass(), RSATypeAnnotation.class), v->v, (v1, v2)->v1));
    }

    @GetMapping("/getKeys")
    @ApiOperation(value = "获取公钥私钥")
    @ApiOperationSupport(author = "学长")
    public ResponseBean getKeys() throws Exception {
        Map<String, Object> genKeyPair = RSAUtils.resetGenKeyPair();

        // 获取公钥
        String publicKey = RSAUtils.getPublicKey(genKeyPair);

        // 获取私钥
        String privateKey = RSAUtils.getPrivateKey(genKeyPair);

        Map<String, String> keys = new HashMap<>();
        keys.put("publicKey", publicKey);
        keys.put("privateKey", privateKey);

        return ResponseBean.ok(keys);
    }

    @PostMapping("/encryptORDecrypt")
    @ApiOperation(value = "加解密")
    @ApiOperationSupport(author = "学长")
    public ResponseBean encryptByPrivateKey(@Valid @RequestBody RSADto dto) throws Exception {
        RSATypeAnnotation rsaTypeAnnotation = new RSATypeAnnotationImpl(dto.getKeyType(), dto.getAction());

        RSAHandler rsaHandler = rsaHandlerMap.get(rsaTypeAnnotation);

        String res = rsaHandler.handler(dto.getData(), dto.getKey());

        Map<String, String> rest = new HashMap<>();

        rest.put("data", res);

        return ResponseBean.ok(rest);
    }
}
