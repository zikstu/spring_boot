package com.medsci.hello.spring.boot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @description: pdf下载
 * @author: 学长
 * @date: 2020/8/26 15:08
 */
@Getter
@Setter
@ApiModel("PDF下载")
public class DownloadPdf {
    @ApiModelProperty("网页路径")
    private String url;

    @ApiModelProperty("文件保存路径")
    private String path;

    @ApiModelProperty("文件名")
    private String fileName;

    public DownloadPdf(String url, String path, String fileName) {
        this.url = url;
        this.path = path;
        this.fileName = fileName;
    }

    public DownloadPdf() {
    }
}
