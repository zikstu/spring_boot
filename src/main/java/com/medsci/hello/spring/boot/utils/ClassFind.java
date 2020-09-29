package com.medsci.hello.spring.boot.utils;

import com.medsci.hello.spring.boot.utils.interfaceutils.ClassFindInterface;

/**
 * @description:
 * @author: 学长
 * @date: 2020/9/29 17:38
 */
public class ClassFind {
    public static Class classFind(ClassFindInterface classFindInterface, String className){
        Class<?> clazz = null;

        try {
            clazz = classFindInterface.classNametoClass(className);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return clazz;
    }
}
