package com.medsci.hello.spring.boot.utils;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.model.ObjectMetadata;
import com.medsci.hello.spring.boot.config.OSSConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @description:
 * @author: 学长
 * @date: 2020/11/5 10:05
 */
public class OSSUtil {
    private OSSUtil(){}

    /**
     * oss 工具客户端
     */
    private volatile static OSSClient ossClient = null;

    /**
     * 初始化 oss 客户端
     * @param ossConfig
     * @return
     */
    private static OSSClient initOSS(OSSConfig ossConfig) {
        if (ossClient == null ) {
            synchronized (OSSUtil.class) {
                if (ossClient == null) {
                    ossClient = new OSSClient(ossConfig.getEndpoint(),
                            new DefaultCredentialProvider(ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret()),
                            new ClientConfiguration());
                }
            }
        }
        return ossClient;
    }

    /**
     * 上传文件至阿里云 OSS
     * 文件上传成功,返回文件完整访问路径
     * 文件上传失败,返回 null
     * @param ossConfig 配置信息
     * @param file 待上传文件
     * @param fileDir 文件保存目录
     * @return oss 中的相对文件路径
     */
    public static String upload(OSSConfig ossConfig, MultipartFile file, String fileDir){
        initOSS(ossConfig);
        StringBuilder fileUrl = new StringBuilder();
        try {
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            String fileName = System.currentTimeMillis() + "-" + UUID.randomUUID().toString().substring(0,18) + suffix;
            if (!fileDir.endsWith("/")) {
                fileDir = fileDir.concat("/");
            }
            fileUrl = fileUrl.append(fileDir + fileName);
            System.out.println(fileUrl+"-----------------");
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType("image/jpg");

            ossClient.putObject(ossConfig.getBucketName(), fileUrl.toString(), file.getInputStream(),objectMetadata);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        fileUrl = fileUrl.insert(0,ossConfig.getUrl());

        return fileUrl.toString();
    }
}
