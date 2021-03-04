package com.medsci.hello.spring.boot.common;

import lombok.Getter;

/**
 * @program: scientific_accelerator
 * @description:
 * @author: Kris_Yao
 * @date: 2020-03-12 13:53
 **/
public enum ExceptionEnum {

    BIND_PARAM_ERROR(503, "参数校验失败"),
    UNAUTHORIZED(401, "认证失败"),
    FORBIDDEN(403, "您的权限不足，无法访问该资源"),
    NOT_FUND(404, "资源不存在"),
    SERVER_FAIL(1000000, "系统异常稍后重试"),
    USER_NOT_FUND(100001, "未找到用户"),
    USER_UPDATE_FAIL(500, "用户修改失败"),
    USER_DELETE_FAIL(500, "用户删除失败"),
    PRODUCT_CREATED_FAIL(500, "添加产品失败");

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private int code;

    private String message;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
