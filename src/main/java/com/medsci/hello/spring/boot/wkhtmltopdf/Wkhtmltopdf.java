package com.medsci.hello.spring.boot.wkhtmltopdf;

import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.params.Param;
import com.medsci.hello.spring.boot.dto.DownloadPdf;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @description: wkhtmltopdf
 * @author: 学长
 * @date: 2020/8/26 15:15
 */
@Component
public class Wkhtmltopdf {
    public File downloadResumePdf(DownloadPdf downloadPdf) throws IOException, InterruptedException {
        String path = downloadPdf.getPath()+"/"+downloadPdf.getFileName()+".pdf";
        Pdf pdf = new Pdf();
        // 为目录添加样式
        //pdf.addTocParam(new Param("--xsl-style-sheet", "my_toc.xsl"));
        // ' wkhtmltopdf ' shell命令接受不同类型的选项，如全局、页面、页眉和页脚，以及toc。详情请参阅“wkhtmltopdf -H”。
        // 参数文档 https://wkhtmltopdf.org/usage/wkhtmltopdf.txt
        pdf.addParam(new Param("--no-outline"));
        pdf.addParam(new Param("--margin-bottom", "0"));
        pdf.addParam(new Param("--margin-right", "0"));
        pdf.addParam(new Param("--disable-smart-shrinking"));
        pdf.addParam(new Param("--page-width", "1000"));

        if (!StringUtils.isEmpty(downloadPdf.getUrl()) && downloadPdf.getUrl().length()>0){
            String url = downloadPdf.getUrl();
            pdf.addPageFromUrl(url);
            return saveAsByUrl(pdf,path);
        }

        return null;
    }

    public File saveAsByUrl(Pdf pdf, String url){
        try {
            return pdf.saveAs(url);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
