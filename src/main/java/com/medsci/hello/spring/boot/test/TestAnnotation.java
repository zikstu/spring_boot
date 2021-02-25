package com.medsci.hello.spring.boot.test;

import com.medsci.hello.spring.boot.annotation.MyAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: 学长
 * @date: 2021/2/25 10:15
 */
public class TestAnnotation {
    public static void main(String[] args) throws Exception{
        // 拿到class 类
        Class clazz = Class.forName("com.medsci.hello.spring.boot.clazz.MyAnnotationClazz");

        //获取类的注解
        Annotation annotation = clazz.getAnnotation(MyAnnotation.class);

        // 拿到类的所有方法
        Method[] methods = clazz.getMethods();

        //遍历所有的方法
        if (methods != null){
            for (Method method : methods){
                boolean annotationPresent = method.isAnnotationPresent(MyAnnotation.class);

                if (annotationPresent){
                    method.invoke(clazz.getConstructor(null).newInstance(null), null);
                }
            }
        }
    }
}
