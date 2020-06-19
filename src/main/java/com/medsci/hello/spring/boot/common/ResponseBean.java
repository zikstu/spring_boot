package com.medsci.hello.spring.boot.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @program: scientific_accelerator
 * @description:
 * @author: Kris_Yao
 * @date: 2020-03-12 13:52
 **/

public class ResponseBean implements Serializable {

    private static final long serialVersionUID = 6503126069715232343L;

    private int returnCode = 200;

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    private String returnMsg = "success";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object body;

    public ResponseBean() {
    }

    public ResponseBean(int returnCode, String returnMsg, Object body) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.body = body;
    }

    public ResponseBean(ExceptionEnum exceptionEnum) {
        this.returnCode = exceptionEnum.getCode();
        this.returnMsg = exceptionEnum.getMessage();
    }

    public ResponseBean(ExceptionEnum exceptionEnum, Object body) {
        this.returnCode = exceptionEnum.getCode();
        this.returnMsg = exceptionEnum.getMessage();
        this.body = body;
    }

    public static ResponseBean ok(String msg) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setReturnCode(200);
        responseBean.setReturnMsg(msg);
        return responseBean;
    }

    public static ResponseBean ok(Object params) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setReturnCode(200);
        responseBean.setReturnMsg("success");
        responseBean.setBody(params);
        return responseBean;
    }

    public static ResponseBean error(ExceptionEnum exceptionEnum) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setReturnCode(exceptionEnum.getCode());
        responseBean.setReturnMsg(exceptionEnum.getMessage());
        return responseBean;
    }

    public static ResponseBean error(ExceptionEnum exceptionEnum, Object body) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setReturnCode(exceptionEnum.getCode());
        responseBean.setReturnMsg(exceptionEnum.getMessage());
        responseBean.setBody(body);
        return responseBean;
    }

    public static ResponseBean error(ExceptionEnum exceptionEnum, String errorMsg) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setReturnCode(exceptionEnum.getCode());
        responseBean.setReturnMsg(errorMsg);
        return responseBean;
    }

    public static ResponseBean error(ExceptionEnum exceptionEnum, String errorMsg, Object body) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setReturnCode(exceptionEnum.getCode());
        responseBean.setReturnMsg(errorMsg);
        responseBean.setBody(body);
        return responseBean;
    }

    public static ResponseBean ok() {
        return new ResponseBean();
    }

}
