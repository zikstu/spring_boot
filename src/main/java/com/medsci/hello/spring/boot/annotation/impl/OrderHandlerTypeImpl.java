package com.medsci.hello.spring.boot.annotation.impl;

import com.medsci.hello.spring.boot.annotation.OrderHandlerType;

import java.lang.annotation.Annotation;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/15 15:14
 */
public class OrderHandlerTypeImpl implements OrderHandlerType {
    private String source;

    private String payMethod;

    public OrderHandlerTypeImpl(String source, String payMethod){
        this.source = source;
        this.payMethod = payMethod;
    }

    @Override
    public String source() {
        return source;
    }

    public String payMethod(){
        return payMethod;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return OrderHandlerType.class;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += (127 * "source".hashCode()) ^ source.hashCode();
        hashCode += (127 * "payMethod".hashCode()) ^ payMethod.hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OrderHandlerType)) {
            return false;
        }
        OrderHandlerType other = (OrderHandlerType) obj;
        return source.equals(other.source()) && payMethod.equals(other.payMethod());
    }
}
