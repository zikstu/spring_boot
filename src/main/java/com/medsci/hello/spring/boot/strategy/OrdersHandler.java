package com.medsci.hello.spring.boot.strategy;

import com.medsci.hello.spring.boot.domain.Orders;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/15 13:54
 */
public interface OrdersHandler {
    void handle(Orders order);
}
