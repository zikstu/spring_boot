package com.medsci.hello.spring.boot.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 一个空的 ArrayList 在第一次添加元素后，底层的 elementData 就会变为一个长度为 10 的数组
 * @author: Arnold
 * @date: 2021/7/22 13:44
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            System.out.println("elementData length : " + getArrayListElementDataLength(list));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        list.add(1);

        try {
            System.out.println("elementData length : " + getArrayListElementDataLength(list));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        System.out.println(2 % 5);
    }

    private static int getArrayListElementDataLength(ArrayList list) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends List> listClass = list.getClass();
        Field field = listClass.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);
        return elementData.length;
    }

}
