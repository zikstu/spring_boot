package com.medsci.hello.spring.boot.config;

import com.alibaba.fastjson.JSONObject;
import com.medsci.hello.spring.boot.common.ExceptionEnum;
import com.medsci.hello.spring.boot.common.ResponseBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/11 17:33
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//        //TODO 捕获AuthenticationException中的message，并封装成自定义异常抛出
        ResponseBean statusResponse = new ResponseBean();
        statusResponse.setReturnCode(ExceptionEnum.UNAUTHORIZED.getCode());
        statusResponse.setReturnMsg(ExceptionEnum.UNAUTHORIZED.getMessage());
        statusResponse.setBody(false);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.write(JSONObject.toJSONString(statusResponse));
        writer.close();

//        httpServletResponse.getWriter().append("weidenglu");
    }
}
