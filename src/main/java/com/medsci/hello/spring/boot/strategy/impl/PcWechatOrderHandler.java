package com.medsci.hello.spring.boot.strategy.impl;

import com.medsci.hello.spring.boot.annotation.OrderHandlerType;
import com.medsci.hello.spring.boot.domain.Orders;
import com.medsci.hello.spring.boot.strategy.OrdersHandler;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/15 14:09
 */
@OrderHandlerType(source = "pc", payMethod = "wechat")
public class PcWechatOrderHandler implements OrdersHandler {
    @Override
    public void handle(Orders order) {
        System.out.println("PC端微信支付订单处理");
    }
}
