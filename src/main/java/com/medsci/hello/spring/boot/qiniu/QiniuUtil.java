package com.medsci.hello.spring.boot.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @description:
 * @author: 学长
 * @date: 2020/6/8 10:36
 */
@Component
public class QiniuUtil {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    final String ACCESS_KEY = "QFrNpYvWfgD0wtRAbJqGCxvQirCmphmmXKu8GziN";

    final String SECRET_KEY = "G6oLGxuaeKrbfUJxub3ql7K7Wr5Xk3uL72xrdPmF";

    //要上传的空间
    final String BUCKET_NAME = "medsci-erp";

    /**
     * 七牛云上传图片
     * @param localFilePath
     * @return
     */
    public String uoloapQiniu (File localFilePath,String fileName, String filePath){
        //构造一个带指定Zone对象的配置类
        Configuration cfg;
        // zone1 华北
        cfg = new Configuration(Zone.zone1());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        //如果是Windows情况下，格式是 D:\23912475_130759767000_2.jpg
//        String localFilePath = "D:\\23912475_130759767000_2.jpg";
        //        String localFilePath = "/home/qiniu/test.png";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = filePath + fileName+"?tId="+System.currentTimeMillis();
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET_NAME);

        String result = null;

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

            String targetUrl = String.format("%s/%s", "https://7n-medsci-erp.medsci.cn", URLEncoder.encode(putRet.key, "utf-8").replace("+", "20%"));

            String privateDownloadUrl = auth.privateDownloadUrl(targetUrl);

            return privateDownloadUrl;

        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
            result = null;
        } catch (UnsupportedEncodingException unsupportedEncodingException){
            System.err.println(unsupportedEncodingException.getMessage());
        }
        return result;
    }

}
