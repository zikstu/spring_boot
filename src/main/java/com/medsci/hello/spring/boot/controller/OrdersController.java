package com.medsci.hello.spring.boot.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.medsci.hello.spring.boot.common.ResponseBean;
import com.medsci.hello.spring.boot.domain.Orders;
import com.medsci.hello.spring.boot.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @description:
 * @author: 学长
 * @date: 2020/9/15 13:36
 */
@RestController
@Api(tags = "订单")
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @ApiOperation(value = "订单列表")
    @ApiOperationSupport(author = "学长")
    @PostMapping("ordersList")
    public ResponseBean ordersList(@RequestParam("source") String source){
        List<Orders> orders = ordersService.ordersList(source);

        return ResponseBean.ok(orders);
    }

    @GetMapping("/findByCode")
    @ApiOperation(value = "根据订单号获取")
    @ApiOperationSupport(author = "学长")
    public ResponseBean findByCode(@RequestParam("code")String code){
        Orders order = ordersService.findByCode(code);

        return ResponseBean.ok(order);
    }
}
