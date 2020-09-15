package com.medsci.hello.spring.boot.service;

import com.medsci.hello.spring.boot.domain.Orders;

import java.util.List;

public interface OrdersService{
    List<Orders> ordersList(String source);

    Orders findByCode(String code);
}
