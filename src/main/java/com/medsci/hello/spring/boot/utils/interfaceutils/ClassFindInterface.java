package com.medsci.hello.spring.boot.utils.interfaceutils;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/29 16:32
 */
@FunctionalInterface
public interface ClassFindInterface {
    Class<?> classNametoClass(String className) throws ClassNotFoundException;
}
