package com.medsci.hello.spring.boot.test;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Arnold
 * @date: 2021/5/8 13:13
 */
public class testString {
    public static void main(String[] args) {
        List<String> list = ImmutableList.of("A", "B", "C");

        String s = list.stream().collect(Collectors.joining(","));

        System.out.printf(s);
    }
}
