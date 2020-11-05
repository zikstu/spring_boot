package com.medsci.hello.spring.boot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @description: 阿里云OSS配置文件
 * @author: 学长
 * @date: 2020/11/5 09:54
 */
@Data
@Configuration
public class OSSConfig implements Serializable {

    private static final long serialVersionUID = 6939417998656270113L;

    /**
     * oss 站点
     */
    @Value("${oss.endpoint}")
    private String endpoint;

    /**
     * oss 资源访问url
     */
    @Value("${oss.url}")
    private String url;

    /**
     * 公钥
     */
    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    /**
     * 私钥
     */
    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;

    /**
     * oss 文件根目录
     */
    @Value("${oss.bucketName}")
    private String bucketName;
}
