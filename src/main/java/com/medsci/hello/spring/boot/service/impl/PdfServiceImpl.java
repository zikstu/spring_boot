package com.medsci.hello.spring.boot.service.impl;

import com.medsci.hello.spring.boot.dto.DownloadPdf;
import com.medsci.hello.spring.boot.service.PdfService;
import com.medsci.hello.spring.boot.wkhtmltopdf.Wkhtmltopdf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


/**
 * @description:
 * @author: 学长
 * @date: 2020/8/26 15:31
 */
@Service
public class PdfServiceImpl implements PdfService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public File create(DownloadPdf downloadPdf) throws IOException, InterruptedException {
        Wkhtmltopdf wkhtmltopdf = new Wkhtmltopdf();

        File file = wkhtmltopdf.downloadResumePdf(downloadPdf);

        return file;
    }
}
