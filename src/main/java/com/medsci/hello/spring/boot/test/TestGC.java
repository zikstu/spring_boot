package com.medsci.hello.spring.boot.test;

/**
 * @description:
 * @author: 学长
 * @date: 2021/3/8 14:40
 */
public class TestGC {
    public static void main(String[] args) {
        if (true){
            byte[] placeHolder = new byte[64 * 1024 * 1024];
            System.out.println(placeHolder.length/1024);
        }
        System.gc();
    }
}
