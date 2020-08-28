package com.medsci.hello.spring.boot.service;

import com.medsci.hello.spring.boot.dto.DownloadPdf;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: 学长
 * @date: 2020/8/26 15:29
 */
public interface PdfService {
    File create(DownloadPdf downloadPdf) throws IOException, InterruptedException;
}
