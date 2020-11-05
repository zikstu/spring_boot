package com.medsci.hello.spring.boot.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.service.FileService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 学长
 * @date: 2020/6/8 14:07
 */
@RestController
@RequestMapping("/file")
public class FileController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private FileService fileService;

    @RequestMapping(value = "/qiniu/upload", method = RequestMethod.POST)
    @ApiOperation(value = "上传图片到七牛")
    @ApiOperationSupport(author = "学长")
    public ResponseBean uploadImg(@RequestParam("file")MultipartFile[] files){
        ResponseBean responseBean = new ResponseBean();

        // 验证非空
        if (StringUtils.isBlank(files[0].getOriginalFilename())) {
            responseBean.setReturnMsg("文件不能为空！");
            responseBean.setReturnCode(422);
        } else {
            Map<String, List<String>> map = new HashMap<>();

            map = fileService.uploadImgs(files);

            List<String> resultList = map.get("result");
            logger.info("图片上传返回结果:"+resultList);

            if ("error".equals(resultList.get(0))) {
                responseBean.setReturnMsg("图片上传失败！");
                responseBean.setReturnCode(500);
            } else {
                responseBean.setReturnMsg("图片上传成功！");
                responseBean.setReturnCode(200);
                responseBean.setBody(resultList);
            }
        }

        return responseBean;
    }

    @PostMapping("/oss/upload")
    @ApiOperation(value = "上传文件到oss")
    @ApiOperationSupport(author = "学长")
    public ResponseBean uploadOss(@RequestParam(value = "file") MultipartFile file){
        String fileUrl = fileService.uploadOss(file);

        return ResponseBean.ok(fileUrl);
    }
}
