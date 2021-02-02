package com.medsci.hello.spring.boot.exception;

import com.medsci.hello.spring.boot.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;

/**
 * @description: 自定义restTemplate异常处理类
 * @author: 学长
 * @date: 2021/2/1 15:10
 */
public class MyRestErrorHandler implements ResponseErrorHandler {
    private static final Logger logger = LoggerFactory.getLogger(MyRestErrorHandler.class);

    /**
     * 判断返回结果response是否是异常结果
     * 主要是去检查response 的HTTP Status
     * 仿造DefaultResponseErrorHandler实现即可
     */
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        int rawStatusCode = clientHttpResponse.getRawStatusCode();

        HttpStatus statusCode = HttpStatus.resolve(rawStatusCode);

        return (statusCode != null ? statusCode.isError(): hasError(rawStatusCode));
    }

    private boolean hasError(int rawStatusCode) {
        HttpStatus.Series series = HttpStatus.Series.resolve(rawStatusCode);

        return (series == HttpStatus.Series.CLIENT_ERROR || series == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        logger.error("===================RestTemplateERROR====================");
        logger.error("DateTime：{}", DateUtil.generateTimeFormatter(response.getHeaders().getDate(),"yyyy-MM-dd HH:mm:ss"));
        logger.error("HOST:{},URI：{}", url.getHost(),url.getPath());
        logger.error("Method：{}", method.name());
        logger.error("Exception：{}", response.getStatusCode());
        logger.error("========================================================");

        throw new MyRestException("handleError！");
//        this.handleError(response);
    }
}

