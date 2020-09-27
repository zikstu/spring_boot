package com.medsci.hello.spring.boot.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/27 13:57
 */
@RestController
@Api(tags = "音频")
@RequestMapping("/audio")
public class AudioController {
    @Resource
    private FileService fileService;

    @PostMapping("/AMR2MP3")
    @ApiOperation(value = "amr音频格式转mp3")
    @ApiOperationSupport(author = "学长")
    public ResponseBean AMR2MP3(@RequestParam("audio") MultipartFile multipartFile){
        /*转格式*/
        String amr2MP3 = fileService.AMR2MP3(multipartFile);

        if (amr2MP3.isEmpty()){
            return ResponseBean.error("转化失败！");
        }

        return ResponseBean.ok(amr2MP3);
    }
}
