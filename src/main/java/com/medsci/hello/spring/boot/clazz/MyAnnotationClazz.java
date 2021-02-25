package com.medsci.hello.spring.boot.clazz;

import com.medsci.hello.spring.boot.annotation.MyAnnotation;

/**
 * @description:
 * @author: 学长
 * @date: 2021/2/25 10:32
 */
public class MyAnnotationClazz {
    @MyAnnotation
    public void testMyAnnotation(){
        System.out.println("testMyAnnotation..");
    }
}
