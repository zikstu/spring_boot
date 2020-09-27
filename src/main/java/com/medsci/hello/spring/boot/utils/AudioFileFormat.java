package com.medsci.hello.spring.boot.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaObject;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/27 13:59
 */
@Component
public class AudioFileFormat {
    @Value("${filePath.sourcePath}")
    private String AMRLOCALPATH;

    @Value("${filePath.uploadPath}")
    private String MP3LOCALPATH;

    /**
     * 上传文件下载到本地
     *
     * @param multipartFile
     */
    public String downloadFile(MultipartFile multipartFile) {
        OutputStream os = null;
        InputStream inputStream = null;
        String fileName = null;
        String fullPath = null;
        try {
            inputStream = multipartFile.getInputStream();
            fileName = multipartFile.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 保存到临时文件
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件,判断文件夹是否存在
            File tempFile = new File(AMRLOCALPATH);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            fullPath = AMRLOCALPATH + multipartFile.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();

                return fullPath;
            } catch (IOException e) {
                e.printStackTrace();
                return fullPath;
            }
        }
    }


    /**
     * 文件格式转换
     *
     * @param multipartFile 目标文件
     * @return
     */
    public File formatConversion(MultipartFile multipartFile) {
        try {
            //转码源文件
            String sourcePath = downloadFile(multipartFile);
            if (null == sourcePath) {
                return null;
            }
            File source = new File(sourcePath);
            //判断文件夹是否存在
            File file = new File(MP3LOCALPATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            //转码本地输出文件
            String saveFilePath = multipartFile.getOriginalFilename();
            saveFilePath = MP3LOCALPATH + saveFilePath.substring(0, saveFilePath.lastIndexOf(".") + 1) + "mp3";
            File target = new File(saveFilePath);

            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(128000);
            audio.setChannels(2);
            audio.setSamplingRate(44100);
            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("mp3");
            attrs.setAudioAttributes(audio);
            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

            return target;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    /**
     * 删除临时文件
     *
     * @param fileName
     */
    public void deleteTempFile(String fileName) {
        String amrFilePath = AMRLOCALPATH + fileName.substring(0, fileName.lastIndexOf(".") + 1) + "amr";
        String mp3FilePath = MP3LOCALPATH + fileName;
        File amrFile = new File(amrFilePath);
        File mp3File = new File(mp3FilePath);
        if (amrFile.isFile() && amrFile.exists()) {
            //存在则进行删除
            amrFile.delete();
        }
        if (mp3File.isFile() && mp3File.exists()) {
            mp3File.delete();
        }
    }
}
