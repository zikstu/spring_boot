package com.medsci.hello.spring.boot.strategy.handle;

import com.medsci.hello.spring.boot.annotation.OrderHandlerType;
import com.medsci.hello.spring.boot.domain.Orders;
import com.medsci.hello.spring.boot.strategy.OrdersHandler;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/15 14:02
 */
@OrderHandlerType(source = "mobile", payMethod = "alipay")
public class MobileAlipayOrderHandler implements OrdersHandler {

    @Override
    public void handle(Orders order) {
        System.out.println("手机端支付宝支付订单处理");
    }
}
