package com.medsci.hello.spring.boot.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 学长
 * @date: 2020/6/8 13:04
 */
public interface FileService {
    /**
     * 多文件上传
     * @param files
     * @return
     */
    Map<String, List<String>> uploadImgs(MultipartFile[] files);

    /**
     * amr转mp3
     * @param multipartFile
     * @return
     */
    String AMR2MP3(MultipartFile multipartFile);

    /**
     * 上传文件到 oss
     * @param file
     * @return
     */
    String uploadOss(MultipartFile file);
}
