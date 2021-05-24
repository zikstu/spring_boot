package com.medsci.hello.spring.boot.service.impl;

import com.medsci.hello.spring.boot.config.OSSConfig;
import com.medsci.hello.spring.boot.qiniu.QiniuUtil;
import com.medsci.hello.spring.boot.service.FileService;
import com.medsci.hello.spring.boot.utils.AudioFileFormat;
import com.medsci.hello.spring.boot.utils.OSSUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @description:
 * @author: 学长
 * @date: 2020/6/8 13:16
 */
@Service
public class FileServiceImpl implements FileService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AudioFileFormat audioFileFormat;

    @Autowired
    private QiniuUtil qiniuUtil;

    @Autowired
    private OSSConfig ossConfig;

    @Override
    public Map<String, List<String>> uploadImgs(MultipartFile[] file){

        Map<String, List<String>> resultMap = new HashMap<>();

        List<String> list = new LinkedList<>();

        String result = null;

        for (int i = 0; i < file.length; i++) {
            String fileName = file[i].getOriginalFilename();

            // 创建一个临时目录文件
            String tempFiles = "temp/"+fileName;
            File dest = new File(tempFiles);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            BufferedOutputStream out = null;
            QiniuUtil qn = new QiniuUtil();

            try {
                out = new BufferedOutputStream(new FileOutputStream(dest));
                out.write(file[i].getBytes());

                Date now = new Date();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                String formatNow = simpleDateFormat.format(now);

                String qiniuFilePath = formatNow +  "/images/";

                /*上传七牛云*/
                result = qn.uoloapQiniu(dest,fileName, qiniuFilePath);

                if (StringUtils.isNotBlank(result)) {
                    list.add(result);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e1) {
                e1.getMessage();
            }  finally{
                try {
                    if (null != out) {
                        out.flush();
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                /*删除临时文件*/
                if (dest.getParentFile().exists()) {
                    dest.delete();
                }
            }
        }
        logger.info("imagesList == " + list);
        if (list.isEmpty()) {
            list.add("error");
        }
        resultMap.put("result",list);
        return resultMap;
    }

    @Override
    public String AMR2MP3(MultipartFile multipartFile){
        /*arm转mp3*/
        File file = audioFileFormat.formatConversion(multipartFile);

        if (file.exists()){
            Date now = new Date();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String formatNow = simpleDateFormat.format(now);

            String qiniuFilePath = formatNow +  "/audio/";

            /*上传七牛*/
            String qiniuUrl = qiniuUtil.uoloapQiniu(file, file.getName(), qiniuFilePath);

            /*删除临时文件*/
            audioFileFormat.deleteTempFile(file.getName());

            return qiniuUrl;
        }

        return null;
    }

    @Override
    public String uploadOss(MultipartFile file) {
        /*格式化时间*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());

        /*oss 上传工具*/
        String ossFileUrl = null;

        /*上传*/
        ossFileUrl = OSSUtil.upload(ossConfig, file, "jpc/" + format);

        return ossFileUrl;
    }
}
