package com.medsci.hello.spring.boot.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.dto.DownloadPdf;
import com.medsci.hello.spring.boot.service.PdfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @description: 处理pdf文件
 * @author: 学长
 * @date: 2020/8/26 15:27
 */
@RestController
@RequestMapping("pdf")
@CrossOrigin("*")
@Api(tags = "pdf相关")
public class PdfController {
    @Resource
    private PdfService pdfService;

    @GetMapping("/download")
    @ApiOperation(value = "pdf下载", notes = "根据网页url生成并下载")
    @ApiOperationSupport(author = "学长")
    public ResponseBean download(@RequestParam(value = "pdfName", required = true) String pdfName,
                             @RequestParam(value = "url", required = true) String url,
                             HttpServletResponse response) throws IOException, InterruptedException
    {
        ResponseBean responseBean = new ResponseBean();

        try{
            DownloadPdf downloadPdf = new DownloadPdf();
            downloadPdf.setFileName(pdfName);
            downloadPdf.setPath("/Users/xuezhang/Wkhtmltopdf");
            downloadPdf.setUrl(url);

            //生成pdf文件
            File pdf = pdfService.create(downloadPdf);

            System.out.println("Created pdf success, path=" + pdf);

            // 如果文件名不为空，则进行下载
            if (pdf != null) {
                //设置文件路径
                String realPath = String.valueOf(pdf);

                File file = new File(realPath);

                String fileName = file.getName();

                // 如果文件名存在，则进行下载
                if (file.exists()) {
                    // 配置文件下载
                    response.setHeader("content-type", "application/octet-stream");
                    response.setContentType("application/octet-stream");
                    // 下载文件能正常显示中文
                    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                    // 实现文件下载
                    byte[] buffer = new byte[1024];
                    FileInputStream fis = null;
                    BufferedInputStream bis = null;
                    try {
                        fis = new FileInputStream(file);
                        bis = new BufferedInputStream(fis);
                        OutputStream os = response.getOutputStream();
                        int i = bis.read(buffer);
                        while (i != -1) {
                            os.write(buffer, 0, i);
                            i = bis.read(buffer);
                        }
                        System.out.println("Download the song successfully!");
                    }
                    catch (Exception e) {
                        System.out.println("Download the song failed!");
                    }
                    finally {
                        if (bis != null) {
                            try {
                                bis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fis != null) {
                            try {
                                fis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }else {
                    responseBean.setReturnMsg("文件不存在！");
                    responseBean.setReturnCode(500);
                }
            }else {
                responseBean.setReturnMsg("PDF创建失败！");
                responseBean.setReturnCode(500);
            }

            return responseBean;

        }catch (Exception exception){
            responseBean.setReturnMsg(exception.getMessage());
            responseBean.setReturnCode(500);
            return responseBean;
        }
    }
}
