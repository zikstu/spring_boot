package com.medsci.hello.spring.boot.nacos;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: 学长
 * @date: 2020/7/3 11:50
 */
@Controller
@RequestMapping("nacos/config")
public class ConfigController {
    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取useLocalCache")
    public boolean get(){
        return useLocalCache;
    }
}
