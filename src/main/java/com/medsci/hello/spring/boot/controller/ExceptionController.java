package com.medsci.hello.spring.boot.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.utils.ClassFind;
import com.medsci.hello.spring.boot.utils.interfaceutils.ClassFindInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/29 10:09
 */
@RestController
@Api(tags = "异常处理")
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/lambda")
    @ApiOperation(value = "lambda")
    @ApiOperationSupport(author = "学长")
    public ResponseBean lambda(@RequestParam(value = "className", defaultValue = "com.medsci.hello.spring.boot.controller.FileController")String className) {
        Class<?> clazz = ClassFind.classFind(o -> Class.forName(o), className);

        if (clazz == null){
            return ResponseBean.error("class not found");
        }

        return ResponseBean.ok(clazz);
    }

}
