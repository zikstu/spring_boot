package com.medsci.hello.spring.boot.service.impl;

import com.medsci.hello.spring.boot.annotation.OrderHandlerType;
import com.medsci.hello.spring.boot.domain.Orders;
import com.medsci.hello.spring.boot.service.OrdersService;
import com.medsci.hello.spring.boot.annotation.impl.OrderHandlerTypeImpl;
import com.medsci.hello.spring.boot.strategy.OrdersHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.medsci.hello.spring.boot.mapper.OrdersMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {
    private Map<OrderHandlerType, OrdersHandler> ordersHandlerMap;

    @Autowired
    public void setOrdersHandlerMap(List<OrdersHandler> ordersHandlers){
        //注入各种类型的订单处理类
        ordersHandlerMap = ordersHandlers.
                stream().
                collect(Collectors.toMap(orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class), v -> v, (v1, v2) -> v1));
    }

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> ordersList(String source){
        List<Orders> allBySource = ordersMapper.findAllBySource(source);

        return allBySource;
    }

    @Override
    public Orders findByCode(String code) {
        Orders order = ordersMapper.findByCode(code);

        if (order != null){
            OrderHandlerType orderHandlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());

            OrdersHandler ordersHandler = ordersHandlerMap.get(orderHandlerType);

            ordersHandler.handle(order);

        }

        return order;
    }

    @Override
    public List<Orders> findAll(){
        List<Orders> all = ordersMapper.findAll();

        return all;
    }
}
